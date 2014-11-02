package com.example.s.dinnerrate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import  com.androidquery.AQuery;


public class MainActivity extends Activity implements View.OnClickListener {
    private ImageButton gpsButton, friendsButton, myVisitsButton, top20Button;
    private Button search, settings;
    private AQuery aq;

    String[] restuarenter = {"DinnerRate", "Cofoco", "MadKlubben", "Tony's", "Noma", "BLa1", "Bla2", "Bla3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        aq = new AQuery(this);

        aq.id(R.id.search).clicked(this, "searchClicked");
        aq.id(R.id.settings).clicked(this, "settingsClicked");
        aq.id(R.id.gps).image(R.drawable.gps).visible().clicked(this, "gpsClicked");
        aq.id(R.id.friends).image(R.drawable.friends).visible().clicked(this, "friendsClicked");
        aq.id(R.id.top20).image(R.drawable.top20).visible().clicked(this, "top20Clicked");
        aq.id(R.id.myvisits).image(R.drawable.myvisits).visible().clicked(this, "myvisitsClicked");


    }



    public  void searchClicked(View b){


    }

    public  void settingsClicked(View b){
        Intent set = new Intent(this, Settings.class);
        startActivity(set);

    }

    public  void gpsClicked(View b){
        // Enten en Maps activitet eller bare en activitet som tager dit gps
        // cordinate og viser en liste med de nærmeste restuarenter hvor
        // du kan vælge den du er på og give den en rating

        //Mangler noget med Maps API key...

        Intent gp = new Intent(this, MapsActivity.class);
        startActivity(gp);

    }

    public  void friendsClicked(View b){
        //Denne activitet er ikke helt færdig udtænkt
        Intent fri = new Intent(this, Friends.class);
        startActivity(fri);

    }

    public  void top20Clicked(View b){
        //Liste med de top20 restuarenter i f.eks danmark, hentet fra database med JSON
        Intent top = new Intent(this, Top20.class);
        startActivity(top);

    }

    public  void myvisitsClicked(View b){
        //Liste med de restuarenter brugeren har været på, hentet fra database med JSON
        Intent my = new Intent(this, MyVisits.class);
        startActivity(my);

    }

    @Override
    public void onClick(View view) {

    }
}
