package edu.pitt.fitpitt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class Signup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_signup);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_signup, menu);
		return true;
	}
	public void toNewUserSecondScreen(View v) {
	    Intent i = new Intent(Signup.this, SignupTwo.class);
	    startActivity(i);
	}

}
