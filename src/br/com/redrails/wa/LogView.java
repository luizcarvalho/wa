package br.com.redrails.wa;

import java.io.File;

import br.com.redrails.wa.R;
import br.com.redrails.util.Logger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;



public class LogView extends Activity {
	String TAG = "WA";
	File log = new File("wa.log");
	Intent intent = new Intent();
	TextView terminal;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_view);
	}


	protected void refresh(){
		Logger log = new Logger("wa.log");
		writeView(log.carregar());
	}
	
	protected void cleanLog(){
		Logger.clean_log();
		refresh();
	}
	
	protected void writeView(String text){
		terminal = (TextView) findViewById(R.id.terminal);
		terminal.setText(text);
	}	
	
	@Override
	protected void onResume() {
		super.onResume();
		refresh();	
	}

	@Override
	public void onPause() {
		super.onPause();
		terminal = (TextView) findViewById(R.id.terminal);
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.log_menu, menu);
	    return true;		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		  switch (item.getItemId()) {
		  case R.id.log_clean:
			  cleanLog();
		    return true;		    
		  case R.id.log_refresh:
			  refresh();
		    return true;	
		  case R.id.go_home:
			  startActivity(new Intent(this,Home.class));
		    return true;		    
		  default:
			  Log.e(TAG, "Opção inválida no menu");
		    return super.onContextItemSelected(item);
		  }
	}
		
}