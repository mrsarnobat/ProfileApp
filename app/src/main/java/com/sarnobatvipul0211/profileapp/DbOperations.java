package com.sarnobatvipul0211.profileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sarno on 27-05-2019.
 */

public class DbOperations extends SQLiteOpenHelper {


    private static final int DB_VERSION=1;
    private static final String DB_NAME="data_info.db";
    private static final String CREATE_QUERY="CREATE TABLE " + DataContract.DataEntry.TABLE_NAME +
            "("
            //+ DataContract.DataEntry.ID + " TEXT , "
                + DataContract.DataEntry.NAME +" TEXT ,"
                + DataContract.DataEntry.MOBILENO + " TEXT ,"
                + DataContract.DataEntry.EMAILID + " TEXT );";

    DbOperations(Context ctx)
    {
        super(ctx,DB_NAME,null,1);
        Log.d("Database Operation","Database Creation...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.d("Database Operation","Table created...");
    }

    public void addData(SQLiteDatabase db,String name,String mobileno,String emailid)
    {
        ContentValues contentValues=new ContentValues();
      //  contentValues.put(DataContract.DataEntry.ID,id);
        contentValues.put(DataContract.DataEntry.NAME,name);
        contentValues.put(DataContract.DataEntry.MOBILENO,mobileno);
        contentValues.put(DataContract.DataEntry.EMAILID,emailid);
        db.insert(DataContract.DataEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operation","Data Inserted...");
    }

    public Cursor getdata(SQLiteDatabase db)
    {
        String[] projections={DataContract.DataEntry.NAME,DataContract.DataEntry.MOBILENO,DataContract.DataEntry.EMAILID};
        Cursor cursor=db.query(DataContract.DataEntry.TABLE_NAME,projections,null,null,null,null,null);

        return cursor;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
