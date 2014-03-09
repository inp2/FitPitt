package edu.pitt.fitpitt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class EventListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_view_event);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
		
		//TextView t = (TextView) findViewById(R.id.textView1);
		//String s = getIntent().getExtras().getString("date");
		//if (s!=null && s.equals("2013/3/27")) { //If you're changing the output, here's where to do it
			//t.setText("1 result found!");
		//}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_list, menu);
		return true;
	}
	
	public void deleteEvent(View v){
		
	}
	
	public void toMain(View v){
		Intent intent = new Intent(EventListActivity.this, MainActivity.class);
		startActivity(intent);
	}
	
	public void toSearch(View v){
		Intent intent = new Intent(EventListActivity.this, SearchActivity.class);
		startActivity(intent);
	}

}
