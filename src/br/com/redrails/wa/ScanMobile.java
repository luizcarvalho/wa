package br.com.redrails.wa;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import br.com.redrails.util.PingParser;

//WIFI
public class ScanMobile extends WAService {
	PingParser ping = null;
	private String module = "Mobile";
	private String ipAddress = "8.8.8.8";
	private int CODE = WAService.MOBILE;
	private boolean stopThis=false;
	private Looper mServiceLooper;
	private ServiceHandler mServiceHandler;

	private class ServiceHandler extends Handler {
		public ServiceHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			ping = new PingParser();
			runService(ping, msg);
			stopSelf(msg.arg1);
		}

	}

	@Override
	public void onCreate() {
		super.onCreate();
		//Log.d(CATEGORIA, "ON CREATE - " + module);

		HandlerThread thread = new HandlerThread("ServiceStartArguments",
				Process.THREAD_PRIORITY_BACKGROUND);
		thread.start();
		mServiceLooper = thread.getLooper();
		mServiceHandler = new ServiceHandler(mServiceLooper);

	}

	@Override
	public void onDestroy() {
//		Log.d(CATEGORIA, "ON DESTROY - " + module);
		stopThis=true;
		stopSelf();
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
	//	Log.d(CATEGORIA, "ON START - " + module);
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {	
		Message msg = mServiceHandler.obtainMessage();
		msg.arg1 = startId;
		mServiceHandler.sendMessage(msg);

		return START_NOT_STICKY;
	}

	protected void runService(PingParser ping, Message msg) {
		Integer rounds = 5;
		Integer currentRound = 0;

		try {
			if (isOnline()) {
				while (!stopThis) {
					synchronized (this) {
						try {
							Log.d(CATEGORIA,module+" PING "+ ipAddress+" "+mobileInterface);
							ping.nqm=0.0;
							ping.runParser(ipAddress, 10, mobileInterface);
							
							
							if (ping.reachable) {
								log_this(module + ":"+ ping.nqm + "\n");
								send_graph(CODE, ping.nqm.toString());
							} else {
								// throw new Exception("Ping sem resposta!");
								log_this(module + ": 0.000000000000000\n");
								send_graph(CODE, "0");
							}
							currentRound++;							
							wait(5000);
							
						} catch (Exception e) {
							Log.d(CATEGORIA,
									"Erro na execução matando o serviço "
											+ module);
							stopSelf(msg.arg1);
						}

					}
					if (currentRound == rounds) {					
						currentRound = 0;
					}
				}
			} else {
				throw new Exception("Network unavaliable");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log_this("Falha na analise! " + e.getMessage() + "\n");
		}
		send_graph(CODE, "0");

	}

}
