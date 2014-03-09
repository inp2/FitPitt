package edu.pitt.fitpitt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_search);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	public void toResults(View v) {
	    Intent i = new Intent(SearchActivity.this, SearchResultsActivity.class);
	    startActivity(i);
	}
	public void toMain(View v){
		Intent intent = new Intent(SearchActivity.this, MainActivity.class);
		startActivity(intent);
	}
	
	public void toSearch(View v){
		Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
		startActivity(intent);
	}

}
