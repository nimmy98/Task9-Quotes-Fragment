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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nimmy on 13-02-2017.
 */

public class CustomAdapter_Grid extends ArrayAdapter<Post> {


    private  Context context;
   private ArrayList<Post> posts = new ArrayList<Post>();
    private   LayoutInflater inflater;
    private  int[] img;
    private Fragment getquoteFrag;
    int layoutResourceId;

    public CustomAdapter_Grid(Context context, int resource, ArrayList<Post> objects,int[]img) {
        super(context, resource, objects);
        this.context = context;
        posts = objects;
        this.layoutResourceId=resource;
        this.img=img;
    }

    static class ViewHolder {

        TextView id,name;
        ImageView im;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
//            convertView = LayoutInflater.from(context).inflate(layoutResourceId,parent,false);
            convertView = LayoutInflater.from(context).inflate(layoutResourceId,parent,false);
            holder.im=(ImageView)convertView.findViewById(R.id.gris_img);
            holder.id = (TextView) convertView.findViewById(R.id.main_TV1);
            holder.name = (TextView) convertView.findViewById(R.id.main_TV2);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

       final  Post post = posts.get(position);

        holder.im.setImageResource(img[position]);
        holder.im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                getquoteFrag  = new ListView_Fragment();
                FragmentManager fm = ((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                bundle.putInt("position", posts.get(position).getId());
                getquoteFrag.setArguments(bundle);
                ft.replace(R.id.main_linear, getquoteFrag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return convertView;
    }
}
