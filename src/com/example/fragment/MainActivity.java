package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	Button btnShowLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		getLocation();	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void getLocation() {
		// create class object
		GPSTracker gps = new GPSTracker(this);

		// check if GPS enabled		
        if(gps.canGetLocation()){
        	
        	double latitude = gps.getLatitude();
        	double longitude = gps.getLongitude();
        	
        	// \n is for new line
        	//Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        	
        	TextView locationView = (TextView) findViewById(R.id.text_location);
    	    locationView.setText("Your Location is - \nLat: " + latitude + "\nLong: " + longitude);
        }else{
        	// can't get location
        	// GPS or Network is not enabled
        	// Ask user to enable GPS/network in settings
        	showGpsAlert();
        }
	}
	
	public void showGpsAlert() {
	    DialogFragment newFragment = new GpsDialogFragment();
	    newFragment.show(getSupportFragmentManager(), "gps");    
	}
	
}
