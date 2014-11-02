package com.example.s.dinnerrate;

import android.app.Activity;

/**
 * Created by Administrator on 15-10-2014.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import  com.androidquery.AQuery;


public class Friends extends Activity  {

    private AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        aq = new AQuery(this);

        aq.id(R.id.search).clicked(this, "buttonClicked");
        aq.id(R.id.settings).clicked(this, "buttonClicked");
    }
}
