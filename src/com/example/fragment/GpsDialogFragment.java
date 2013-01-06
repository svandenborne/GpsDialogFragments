package com.example.fragment;

import com.example.gpsfragmentdialog.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;

public class GpsDialogFragment extends DialogFragment{
	
	public GpsDialogFragment() {
        // Empty constructor required for DialogFragment
    }
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
     // Setting Dialog Title
        builder.setTitle(R.string.gps_dialog_title);
        
        builder.setMessage(R.string.gps_dialog_msg)
               .setPositiveButton(R.string.gps_dialog_enable, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // show settings
                	   Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                	   getActivity().startActivity(intent);
                   }
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                	   dialog.cancel();
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
	

}

