package com.example.s.dinnerrate;

import android.app.Activity;

/**
 * Created by Administrator on 15-10-2014.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import  com.androidquery.AQuery;


public class Top20 extends Activity implements AdapterView.OnItemClickListener {

    String[] restuarenter = {"DinnerRate", "Cofoco", "MadKlubben", "Tony's", "Noma", "BLa1", "Bla2", "Bla3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        ListView listView = new ListView(this);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.liste, R.id.liste, restuarenter);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        listView.setDivider(getResources().getDrawable(android.R.drawable.divider_horizontal_bright));
        setContentView(listView);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
