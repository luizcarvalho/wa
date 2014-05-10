package br.com.redrails.wa;

import br.com.redrails.util.Logger;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


public class WAService extends Service {
	public static final String CATEGORIA = "WA";
	protected static final int WIFI = 1;
	protected static final int MOBILE = 2;
	public static final String BROADCAST_ACTION = "br.com.redrails.wa.displayevent";
	protected static String  mobileInterface = "";
	protected static String  wifiInterface = "";
	protected int mStart;	
	Intent intent;

	public static Logger log = new Logger("wa.log");

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(CATEGORIA, "BINDED");
		return null;
	}
	
	
	@Override
	public void onCreate() {

		SharedPreferences interfaces = getSharedPreferences("INTERFACES",MODE_WORLD_WRITEABLE);
		mobileInterface = interfaces.getString("mobile", "null");		

		wifiInterface = interfaces.getString("wifi", "null");
		
		intent = new Intent(BROADCAST_ACTION);
		//Log.d(CATEGORIA, "ON CREATE - Criando Serviço");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		//Log.d(CATEGORIA, "ON START - Iniciando Serviço");

	}

	@Override
	public void onDestroy() {
		stopSelf();
		Log.d(CATEGORIA,"ON DESTROY - WA SERVICE");
	}
	
	
	
//==== RUN SERVICES


	
	
	

	
	
	
	
	
	
	
	public boolean isOnline() {
		 ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		 return cm.getActiveNetworkInfo().isConnectedOrConnecting();
		}


	protected void log_this(String str) {
		log.salvar(str);
	}
	
	protected void send_graph(int type,String nqm){
		Float floatObject = new Float(nqm);
	    byte value = floatObject.byteValue();
	    intent.putExtra("nqm",value);
	    intent.putExtra("tipo",type);
	    sendBroadcast(intent);
	}
	
	

}