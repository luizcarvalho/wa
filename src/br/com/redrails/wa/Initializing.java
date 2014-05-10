package br.com.redrails.wa;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import br.com.redrails.util.SuDroid;
import br.com.redrails.util.SuDroid.CommandResult;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Initializing extends Activity {
	public final String CATEGORIA = "WA";
	private List<String> deviceInterfaces = new ArrayList<String>();
	ArrayAdapter<String> aChoose;
	Spinner mobileChooser;
	Spinner wifiChooser;

	// Animation hyperspaceJump = AnimationUtils.loadAnimation(this,
	// R.anim.fade);

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		shutup();
		getInterface();
		aChoose = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, deviceInterfaces);
		final Spinner mobileSpinner = (Spinner) findViewById(R.id.mobileInterface);
		final Spinner wifiSpinner = (Spinner) findViewById(R.id.wifiInterface);
		Button continueButton = (Button) findViewById(R.id.btChoose);
		mobileSpinner.setAdapter(aChoose);
		wifiSpinner.setAdapter(aChoose);

		continueButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mobileSpinner.getSelectedItemId() == Spinner.INVALID_ROW_ID
						|| wifiSpinner.getSelectedItemId() == Spinner.INVALID_ROW_ID) {

					AlertDialog.Builder dialogo = new AlertDialog.Builder(Initializing.this);
					dialogo.setTitle("Ops");
					dialogo.setMessage("Você deve selecionar as interfaces");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				} else {	
					Intent intent = new Intent();
					intent.setClassName("br.com.redrails.wa", "br.com.redrails.wa.Home");
					SharedPreferences interfaces = getSharedPreferences("INTERFACES",MODE_WORLD_WRITEABLE);
					SharedPreferences.Editor  editor = interfaces.edit();
					editor.putString("mobile", mobileSpinner.getSelectedItem().toString());
					editor.putString("wifi", wifiSpinner.getSelectedItem().toString());
					if(editor.commit())
					startActivity(intent);
				}
				// savedInstanceState.putString("mobile", mobileSpinner.getS)
			}
		});

	}


	
	public void shutup(){
		SuDroid cmd = new SuDroid();
		cmd.sh.runWaitFor("svc wifi enable");
		cmd.sh.runWaitFor("svc data enable");
		cmd.sh.runWaitFor("svc data prefer");
		Toast.makeText(Initializing.this, "Tentando ativar ambas interfaces simultaneamente...",Toast.LENGTH_SHORT).show();
		//su.exec("svc data prefer");
		//WIFI: 208.67.222.222
		//su.exec("ip route add 208.67.222.222 dev wlan0");
		
	}	
	
	
	public void getInterface() {
   	 SuDroid cmd = new SuDroid();
	 CommandResult r = cmd.sh.runWaitFor("netcfg");

		Pattern statisticPattern = Pattern.compile("(\\w*)\\s*UP");

		Matcher statisticMatcher = statisticPattern.matcher(r.stdout);
		while (statisticMatcher.find()) {
			if (!statisticMatcher.group(1).equals("lo")) {
				deviceInterfaces.add(statisticMatcher.group(1));
			}
		}

	}

}