package com.sarnobatvipul0211.profileapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by sarno on 28-05-2019.
 */

public class BackgroundTask extends AsyncTask<String,Data,String> {

    Context ctx;
    DataAdapter dataAdapter;
    Activity activity;
    ListView listView;
    public BackgroundTask(Context ctx) {
        this.ctx = (Context) ctx;
        activity=(Activity)ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String method=params[0];
        DbOperations dbOperations=new DbOperations(ctx);
        if (method.equals("add_data"))
        {
          //  String Id=params[1];
            String Name=params[1];
            String Mobileno=params[2];
            String Emailid=params[3];
            SQLiteDatabase db=dbOperations.getWritableDatabase();
            dbOperations.addData(db,Name,Mobileno,Emailid);

            return "Data Inserted...";
        }

        else if(method.equals("get_data"))
        {
            listView=activity.findViewById(R .id.display_listview);
            SQLiteDatabase db=dbOperations.getReadableDatabase();
            Cursor cursor=dbOperations.getdata(db);
            dataAdapter=new DataAdapter(ctx,R.layout.display_data_row);
            String name,mobileno,emailid;
            while (cursor.moveToNext())
            {
                name=cursor.getString(cursor.getColumnIndex(DataContract.DataEntry.NAME));
                mobileno=cursor.getString(cursor.getColumnIndex(DataContract.DataEntry.MOBILENO));
                emailid=cursor.getString(cursor.getColumnIndex(DataContract.DataEntry.EMAILID));
                Data data=new Data(name,mobileno,emailid);
                publishProgress(data);
            }
            return "get_data";
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_data"))
        {
            listView.setAdapter(dataAdapter);
        }
        else {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onProgressUpdate(Data... values) {
        dataAdapter.add(values[0]);
    }
}
