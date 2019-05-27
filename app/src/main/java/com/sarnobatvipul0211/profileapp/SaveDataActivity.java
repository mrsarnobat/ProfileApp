package com.sarnobatvipul0211.profileapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveDataActivity extends AppCompatActivity {

    TextInputEditText e_id,e_name,e_mobileno,e_emailid;
    String id,name,mobileno,emailid;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

      //  e_id=(TextInputEditText)findViewById(R.id.d_id);
        e_name=(TextInputEditText)findViewById(R.id.d_name);
        e_mobileno=(TextInputEditText)findViewById(R.id.d_mobileno);
        e_emailid=(TextInputEditText)findViewById(R.id.d_emailid);
        btnAddData=(Button)findViewById(R.id.btnadddata);


/*
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=e_id.getText().toString();
                name=e_name.getText().toString();
                mobileno=e_mobileno.getText().toString();
                emailid=e_emailid.getText().toString();

                BackgroundTask backgroundTask=new BackgroundTask(this);
                backgroundTask.execute("add_data",id,name,mobileno,emailid);

                finish();
            }
        });
*/

    }

    public void savedata(View view)
    {
      //  id=e_id.getText().toString();
        name=e_name.getText().toString();
        mobileno=e_mobileno.getText().toString();
        emailid=e_emailid.getText().toString();

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("add_data",name,mobileno,emailid);

        finish();

    }
}
