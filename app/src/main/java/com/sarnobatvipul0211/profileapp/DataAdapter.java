package com.sarnobatvipul0211.profileapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarno on 28-05-2019.
 */

public class DataAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public DataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Data object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        DataHolder dataHolder;
        if (row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.display_data_row,parent,false);
            dataHolder=new DataHolder();
            dataHolder.tx_name=(TextView)row.findViewById(R.id.t_name);
            row.setTag(dataHolder);
        }
        else {
            dataHolder=(DataHolder)row.getTag();
        }
        Data data=(Data)getItem(position);
        dataHolder.tx_name.setText(data.getName().toString());
        return row;
    }

    static class DataHolder
    {
        TextView tx_name;
    }

}
