package br.com.redrails.util;
//http://www.javaperformancetuning.com/tips/rawtips.shtml


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;
import br.com.redrails.util.SuDroid;
import br.com.redrails.util.SuDroid.CommandResult;


/**
 * @author Luiz Carvalho
 *
 */
public class PingParser {
	private String CATEGORIA="WA";
	public static Integer packetsLosts=0;
	public Integer packetsReceiveds;
	public Integer packetsSendeds;
	public Double min;
	public Double max;
	public Double avg;
	public Double mdev;
	public Double somaPings = 0.0d;
	public Double somaJitters = 0.0d;
	public Double nqm;
	public boolean reachable=false;
	public SuDroid su;
	
	private Double[] pings = {0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d};
	private Double[] jitters = {0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d,0.0d};
	
	
	public Integer line;
	
	//informe o hostname e a quantidade de pings a ser executado
	public PingParser(){
		su = new SuDroid();
		packetsReceiveds=line=0;		
	}
	
	
	/*Incrementa em uma linha o interador. Caso não haja mais linhas retorna false.
	     do{
        	   Log.d(TAG,pingParserObject.getTime());
           }while(pingParserObject.nextLine());
	 */
	public Boolean nextLine(){
		line++;
		return line<(packetsReceiveds);
	}
	
	//Retorna o tempo em cada ping em ms. Para incrementar a linha utilize nextLine()
	public Double getTime(){
		Double time = pings[line];
		return time;
	}
	
	//Retorna o jitter de cada ping em ms. Para incrementar a linha utilize nextLine()
	public Double getJitter(){
		Double jitter = jitters[line];
		return jitter;
	}	
		
	//retorna o Jitter a cada linha do ping. Deve ser utilizado em conjunto com a criação dos pings
	protected Double calculateJitter(){
		Double lastTime = new Double(0);
		if(packetsReceiveds==0)
			lastTime=pings[packetsReceiveds];
		else
			lastTime=pings[packetsReceiveds-1];
		
		Double jitter = pings[packetsReceiveds]-lastTime;
		if(jitter<0)
			return -1*jitter;
		return jitter;
	}
	
	//executa a função principal. O Parser retirar os dados do ping realizado.
	//Como Tempo de atraso de cada ping, jitter, menor e maior tempo de atraso,
	//além da média entre todos. Os valores são atribuidos a variáveis de acesso global
	public void runParser(String host,Integer rounds,String gw) {
		nqm=0.0;
		packetsSendeds = rounds;
    	String pingResult = runPing(host,rounds,gw);
    	
    	
        Pattern pingPattern = Pattern.compile("time=([0-9]*\\.?[0-9]*)");        
        Matcher matcher = pingPattern.matcher(pingResult);        
        try{
        while (matcher.find()) {            
        	somaPings = somaPings + (pings[packetsReceiveds]=(new Double(matcher.group(1))));
        	//Log.d(CATEGORIA,somaPings.toString());
        	somaJitters=somaJitters + (jitters[packetsReceiveds]=calculateJitter());
        	packetsReceiveds++;
        }
    	}catch (Exception e) {
   		 Log.e(CATEGORIA,"ERRO: "+e.getMessage());
		}   	
    	//Log.d(CATEGORIA,"valores do ping capiturados");
        Pattern statisticPattern = Pattern.compile("mdev = ([-+]?[0-9]*\\.?[0-9]*)/([-+]?[0-9]*\\.?[0-9]*)/([-+]?[0-9]*\\.?[0-9]*)/([-+]?[0-9]*\\.?[0-9]*)");
        
        Matcher statisticMatcher = statisticPattern.matcher(pingResult);  
        if(statisticMatcher.find()){
        	min = (new Double(statisticMatcher.group(1)));        
        	avg = (new Double(statisticMatcher.group(2)));
        	max = (new Double(statisticMatcher.group(3)));
        	mdev = (new Double(statisticMatcher.group(4)));
        }

		if(max != null){
		CalculateQOSVariables();
		reachable=true;
		}else{
			reachable=false;			
		}
        
    }

    //Executa o comando ping, retornando uma string com seu respectivo resultado.
    public String runPing(String host,Integer rounds,String gw){
    	
    	String command ="ping -c "+rounds+" "+"-I "+gw+" "+host;
    	 SuDroid cmd = new SuDroid();
    	 Log.d(CATEGORIA,"Executando => "+command);
    	 CommandResult r = cmd.sh.runWaitFor(command);
    	 
    	  if (!r.success()) {
    	      return r.stderr;
    	  } else {
    	      return r.stdout;
    	 }    	

    }    
    
    
    private void CalculateQOSVariables(){
    	Double n = new Double(packetsReceiveds);
    	Double varianciaDeJitter= 0.0d;
    	Double varianciaDeAtraso= 0.0d;
    	Double atrasoMedio = somaPings/n;//todos os atrasos dividos pela quantidade de atrasos
    	Double jitterMedio = somaJitters/n;//todos os jitters dividos pela quantidade de jitters
    	Double maxJitter ;
    	Double minJitter ;
    	
    	//zerar NQL

    	
    	do{
    	   varianciaDeAtraso=(Double) (varianciaDeAtraso+Math.pow(getTime(), 2.0d));// Soma dos Pings
    	   varianciaDeJitter=(Double) (varianciaDeJitter+Math.pow(getJitter(), 2.0d)); // Soma dos Jitters
    	}while(nextLine());
    	line=0;
    	
    	varianciaDeAtraso = varianciaDeAtraso/n;
    	varianciaDeJitter= varianciaDeJitter/n;    	
    	
    	Double automaticVideoQuality = Math.random()/100000000.0d;
    	automaticVideoQuality=(automaticVideoQuality%5)+1.0d;    
    	//Log.d("WA",max+"-"+min);
    	Double deltaAtraso = max-min;//as variáveis max e min são retiradas do comando pin   	
    	Arrays.sort(jitters); 
    	maxJitter = jitters[packetsReceiveds-1];
    	minJitter = jitters[0];
    	Double deltaJitter = maxJitter-minJitter;   	

    	if(packetsLosts==0)
    	packetsLosts = 1;
    	Double deltaPerda = new Double(packetsLosts);
    	Double maiorPerda = deltaPerda;
    	Double perdaMedia=deltaPerda/packetsSendeds; 
    	nqm = (((((-4d/deltaJitter)*(jitterMedio-maxJitter))+1d)*0.5d)+
    	((((-4d/deltaAtraso)*(atrasoMedio-max))+1)*0.1d)+
    	((((-4d/deltaPerda)*(perdaMedia-maiorPerda))+1)*0.4d));
    	Log.e(CATEGORIA,"NQM: "+nqm);
    }	
    
}

