package com.kernel.appcompatlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kernel.appcompat.AppCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompat.supportLibrary(getPackageName(),this);
    }
}