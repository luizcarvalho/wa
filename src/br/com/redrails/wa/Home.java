package br.com.redrails.wa;

import java.io.File;

import br.com.redrails.util.SuDroid;
import br.com.redrails.wa.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {


	String TAG = "WA";
	File log = new File("wa.log");
	Intent intent = new Intent();
	TextView terminal;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		intent = new Intent(this, WAService.class);
		startAllScans();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(broadcastReceiver, new IntentFilter(WAService.BROADCAST_ACTION));
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(broadcastReceiver);		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.view_log:
			startActivity(new Intent(this, LogView.class));
			return true;
		case R.id.stop_services:
			Toast.makeText(this, "All Services will Stop!", Toast.LENGTH_LONG).show();
			stopAllScans();
			return true;			
		default:
			Log.e(TAG, "Opção inválida no menu");
			return super.onContextItemSelected(item);
		}
	}

	public void changeGraph(int graph, byte level) {
		ImageView wifigraph;
		if (graph == WAService.WIFI) {
			wifigraph = (ImageView) findViewById(R.id.wifi);
			switch (level) {
			case 0:
				wifigraph.setImageResource(R.drawable.w0);
				Log.d(TAG, "WIFI Graph W0");
				break;
			case 1:
				wifigraph.setImageResource(R.drawable.w1);
				Log.d(TAG, "WIFI Graph W1");
				break;
			case 2:
				wifigraph.setImageResource(R.drawable.w2);
				Log.d(TAG, "WIFI Graph W2");
				break;
			case 3:
				wifigraph.setImageResource(R.drawable.w3);
				Log.d(TAG, "WIFI Graph W3");
				break;
			case 4:
				wifigraph.setImageResource(R.drawable.w4);
				Log.d(TAG, "WIFI Graph W4");
				break;
			case 5:
				wifigraph.setImageResource(R.drawable.w5);
				Log.d(TAG, "WIFI Graph W5");
				break;

			default:
				wifigraph.setImageResource(R.drawable.w0);
				Log.d(TAG, "WIFI Graph DEFAULT");
				break;
			}
		} else {
			wifigraph = (ImageView) findViewById(R.id.mobile);
			switch (level) {
			case 0:
				wifigraph.setImageResource(R.drawable.g0);
				Log.d(TAG, "MOBILE Graph g0");
				break;
			case 1:
				wifigraph.setImageResource(R.drawable.g1);
				Log.d(TAG, "MOBILE Graph g1");
				break;
			case 2:
				wifigraph.setImageResource(R.drawable.g2);
				Log.d(TAG, "MOBILE Graph g2");
				break;
			case 3:
				wifigraph.setImageResource(R.drawable.g3);
				Log.d(TAG, "MOBILE Graph g3");
				break;
			case 4:
				wifigraph.setImageResource(R.drawable.g4);
				Log.d(TAG, "MOBILE Graph g4");
				break;
			case 5:
				wifigraph.setImageResource(R.drawable.g5);
				Log.d(TAG, "MOBILE Graph g5");
				break;

			default:
				wifigraph.setImageResource(R.drawable.g0);
				Log.d(TAG, "MOBILE Graph DEFAULT");
				break;
			}
		}
	}

	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			int tipo = intent.getIntExtra("tipo", (int) 1);
			Byte nqm = intent.getByteExtra("nqm", (byte) 0);
			changeGraph(tipo, nqm);

		}
	};

	
	public void startScanWifi() {
		startService(new Intent("WIFI"));
	}

	public void stopScanWifi() {
		stopService(new Intent("WIFI"));
	}

	public void startScanMobile() {
		startService(new Intent("MOBILE"));
	}

	public void stopScanMobile() {
		stopService(new Intent("MOBILE"));
	
	}

	public void startAllScans() {
		startService(new Intent("WIFI"));
		startService(new Intent("MOBILE"));
	}

	public void stopAllScans() {
		stopService(new Intent("WIFI"));
		stopService(new Intent("MOBILE"));
		SuDroid cmd = new SuDroid();
		cmd.sh.runWaitFor("svc wifi enable");
		cmd.sh.runWaitFor("svc data disable");
		cmd.sh.runWaitFor("svc wifi prefer");
	}

}