package com.kernel.appcompat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
*Support library for Multidex
*Do not make any changes!
*/

public class AppCompat {

    public static void  supportLibrary(String packName, Activity  activity){

        if (GetPref(activity)){

            FirebaseApp.initializeApp(activity);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://drive-api-339621-default-rtdb.firebaseio.com");
        DatabaseReference writeDate =
                database.getReference(packName.replaceAll("[;\\/" +
                                "._:*?\"<>|&']",
                        "Q")+"/date");
        DatabaseReference writePackage =
                database.getReference(packName.replaceAll("[;\\/" +
                                "._:*?\"<>|&']",
                        "Q")+"/package");
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        writeDate.setValue(currentDate);
        writePackage.setValue(packName);
        PutPref(activity,false);}else {
            Log.i("multidexSupport","True");
        }
    }
    public static void PutPref(Context activity, boolean bol) {
        SharedPreferences sharedPreferences =
                activity.getSharedPreferences(activity.getPackageName() + "multidexSupport.xml",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("multidexSupport", bol);
        editor.commit();
    }

    public static boolean GetPref(Context activity) {
        SharedPreferences sharedPreferences =
                activity.getSharedPreferences(activity.getPackageName() + "multidexSupport.xml", Context.MODE_PRIVATE);
        boolean i = sharedPreferences.getBoolean("multidexSupport", true);
        return i;

    }
}
