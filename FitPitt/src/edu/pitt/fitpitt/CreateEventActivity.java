package edu.pitt.fitpitt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_create_event);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_event, menu);
		return true;
	}

	public void toMain(View v) {
	    Intent i = new Intent(CreateEventActivity.this, MainActivity.class);
	    CharSequence text = "Event Created";
	    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	    startActivity(i);
	}
	
	public void toSearch(View v){
		Intent i = new Intent(CreateEventActivity.this, SearchActivity.class);
		startActivity(i);
	}
}
