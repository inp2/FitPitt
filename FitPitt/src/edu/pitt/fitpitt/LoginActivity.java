package edu.pitt.fitpitt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	
	private EditText username;
	private EditText password;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
        
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

	}
	public void toCreateAccount(View v) {
	    Intent i = new Intent(LoginActivity.this, Signup.class);
	    startActivity(i);
	    
	}
	
	public void toMainScreen(View v) {
		ProgressDialog pDialog;
		pDialog = ProgressDialog.show(this, "dialog title","dialog message", true);
		if(username.getText().toString().length() > 0 && password.getText().toString().length() > 0){
			Intent i = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(i);
		}
		else{
			Toast.makeText(this, "The username or password entered is incorrect.", Toast.LENGTH_LONG).show();
		}
		pDialog.dismiss();
	}
	
}
