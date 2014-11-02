package com.example.s.dinnerrate;

import android.app.Activity;

/**
 * Created by Administrator on 15-10-2014.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import  com.androidquery.AQuery;


public class Friends extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_friends, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
        tv.setText("Ikke Besluttet hvad \n der skal være her");

        return v;
    }

    public static Friends newInstance(String text) {

        Friends f = new Friends();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}