package br.com.redrails.util;
/*
 * Luiz Carvalho
 * @LuizCarvalho
 * luizcarvalho@redrails.com.br
 * www.redrails.com.br
 * http://br.linkedin.com/in/luizkarvalho (recommend me) 
 * more in http://www.redrails.com.br/tags/QoV/
 * 
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.util.Log; 

public class SuDroider {
	private static final String SU = "su";
	public String success_msg = null;
	public String error_msg = null;
	public String exception = null;
	public Boolean success = false;
	public Process globalProc = null;

	public SuDroider(){
		try {
			globalProc = Runtime.getRuntime().exec(SU);
		} catch (IOException e) {
			showException(e.getMessage());
		}
		
	}

	public void exec(String command) {
		Process proc = run(command);

		try {

			if (proc.waitFor() == 0)
				success = true;

			success_msg = getResult(proc.getInputStream());
			error_msg = getResult(proc.getErrorStream());

		} catch (InterruptedException ex) {
			success = false;
			showException(ex.toString());
		} catch (NullPointerException ex) {
			success = false;
			showException(ex.toString());
		}

	}

	public String result() {
		if(success || success_msg.length()!=0){
			return success_msg;
		}		
		return error_msg;
	}

	public Process run(String command) {
		try {
			globalProc = Runtime.getRuntime().exec(SU);
			DataOutputStream dataProc = new DataOutputStream(globalProc.getOutputStream());
			dataProc.writeBytes("exec " + command + "\n");
			dataProc.flush();
		} catch (Exception ex) {
			showException(ex.getMessage());
			success = false;
			globalProc = null;
		}
		return globalProc;
	}

	private String getResult(InputStream istream) {
		String line = null;
		StringBuffer result = new StringBuffer();
		BufferedReader dataIstream = new BufferedReader(new InputStreamReader(
				istream), 2*1024);

		try {
			while ((line = dataIstream.readLine()) != null) {
				result.append(line + "\n");
			}
			dataIstream.close();
		} catch (Exception ex) {
			success = false;
			showException(ex.getMessage());
		}
			return result.toString();		
	}

	public void showException(String msg) {
		exception = exception +"\n"+ msg;
		//Log.d(TAG,msg); // IF NOT ANDROID
		Log.e("WA", "SuDroid Exeception:  " + msg);
	}

}
