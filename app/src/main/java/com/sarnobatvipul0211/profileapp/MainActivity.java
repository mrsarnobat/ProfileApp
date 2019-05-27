package com.sarnobatvipul0211.profileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Button adddata;
    Button profilelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adddata=(Button)findViewById(R.id.addbtn);
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SaveDataActivity.class);
                startActivity(intent);
            }
        });


    }

    public void displayprofiles(View view)
    {
         Intent intent=new Intent(MainActivity.this,DisplyaDataActivity.class);
        startActivity(intent);

    }

}
