package edu.pitt.fitpitt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class SearchResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_search_results);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_results, menu);
		return true;
	}
	
	public void toSearch(View v)
	{
		Intent intent = new Intent(SearchResultsActivity.this, SearchActivity.class);
		startActivity(intent);
	}
	
	public void toMain(View v)
	{
		Intent intent = new Intent(SearchResultsActivity.this, MainActivity.class);
		startActivity(intent);
	}
	

}
