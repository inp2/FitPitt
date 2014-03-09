package edu.pitt.fitpitt;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.TimePickerDialog;

public class SignupTwo extends FragmentActivity implements OnClickListener {

	protected Button selectSportsButton;
	protected Button finishNewUser;
	private static Context context;
	 
	protected CharSequence[] sports = { "Football", "Basketball", "Baseball", "Soccer", "Tennis", "Bodybuilding" };
	protected ArrayList<CharSequence> selectedSports = new ArrayList<CharSequence>();
	  
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		context = this;
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_signup_two);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fitpitt_title);
		
		selectSportsButton = (Button) findViewById(R.id.selectsports);
		selectSportsButton.setOnClickListener(this);
		
		finishNewUser = (Button) findViewById(R.id.finish);
		finishNewUser.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SignupTwo.this, MainActivity.class);
			    startActivity(i);
			}
			
		});
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
	      case R.id.selectsports:
	        showSelectSportsDialog();
	        break;
	 
	      default:
	        break;
	    }
	}
	
	protected void showSelectSportsDialog() {
		  boolean[] checkedsports = new boolean[sports.length];
		  int count = sports.length;
		 
		  for(int i = 0; i < count; i++)
		    checkedsports[i] = selectedSports.contains(sports[i]);
		 
		  DialogInterface.OnMultiChoiceClickListener sportsDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
		   @Override
		    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
		      if(isChecked)
		        selectedSports.add(sports[which]);
		      else
		        selectedSports.remove(sports[which]);
		 
		      onChangeSelectedSports();
		    }
		   };
		 
		  AlertDialog.Builder builder = new AlertDialog.Builder(this);
		  builder.setTitle("Select sports");
		  builder.setMultiChoiceItems(sports, checkedsports, sportsDialogListener);
		  builder.setPositiveButton("OK", new DialogInterface.OnClickListener() 
	        {
	            // when user clicks OK, save the drawing to a file in JPEG format
	            public void onClick(DialogInterface dialog, int button) 
	            {
	            	dialog.dismiss();
	            }
	        });
		  
		  AlertDialog dialog = builder.create();
		  
		  dialog.show();
		}
	
	protected void onChangeSelectedSports() {
		  StringBuilder stringBuilder = new StringBuilder();
		 
		  for(CharSequence sport : selectedSports)
		    stringBuilder.append(sport + ",");
		 
		  selectSportsButton.setText(stringBuilder.toString());
		}
	
	public void showTimePickerDialog(View v) {
	    DialogFragment newFragment = new TimePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "timePicker");
	}
	
	public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);

			// Create a new instance of TimePickerDialog and return it
			return new TimePickerDialog(getActivity(), this, hour, minute,
					DateFormat.is24HourFormat(getActivity()));
		}


		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			String time = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
				    Toast.makeText(context, time, Toast.LENGTH_LONG).show();
		}
	}

}
