package com.example.nimmy.task9_quotes_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by Nimmy on 13-02-2017.
 */

public class CustomAdapter_List extends ArrayAdapter {

    private Fragment bigQuote;

    Context context;
    ArrayList<Post2> posts2 = new ArrayList<>();
    LayoutInflater inflater;
    int layoutResourceId;


    public CustomAdapter_List(Context context, int resource, ArrayList<Post2> objects){
        super(context, resource, objects);
        this.context = context;
        this.posts2 = objects;
        this.layoutResourceId = resource;
    }

    static class ViewHolder
    {
        TextView textView1,textView2,textView3;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(layoutResourceId,parent,false);
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_id);
            holder.textView2 = (TextView) convertView.findViewById(R.id.list_cat_id);
            holder.textView3=(TextView)convertView.findViewById(R.id.list_quotes);

            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }
//        holder.textView1.setText(posts2.get(position).getId());
//        holder.textView2.setText(posts2.get(position).getCat_id());

        final Post2 post2 = posts2.get(position);
        holder.textView3.setText(post2.getQuotes());

        //holder.textView3.setText(posts2.get(position).getQuotes());

        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bigQuote = new ThirdFragment();
                FragmentManager fm = ((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                bundle.putString("Quote", post2.getQuotes());
                bigQuote.setArguments(bundle);
                ft.replace(R.id.main_linear, bigQuote);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return convertView;
    }
}
