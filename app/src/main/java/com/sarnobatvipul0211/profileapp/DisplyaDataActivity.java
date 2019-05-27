package com.sarnobatvipul0211.profileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplyaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displya_data);

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("get_data");

    }
}
