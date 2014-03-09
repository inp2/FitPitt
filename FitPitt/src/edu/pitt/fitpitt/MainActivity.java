package edu.pitt.fitpitt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void toCreateEvent(View v) {
	    Intent i = new Intent(MainActivity.this, CreateEventActivity.class);
	    startActivity(i);
	    
	}
	public void toEventResults(View v) {
	    Intent i = new Intent(MainActivity.this, EventListActivity.class);
	    Bundle b = new Bundle();
	    DatePicker picker = (DatePicker)findViewById(R.id.datePicker1);
	    String date = "" + picker.getYear() + "/" + (picker.getMonth()+1) + "/" + picker.getDayOfMonth();  
	    b.putString("date",date);
	    i.putExtras(b);
	    startActivity(i);
	    
	}
	
	public void toMain(View v){
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		startActivity(intent);
	}
	
	public void toSearch(View v){
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		startActivity(intent);
	}
}
