package com.example.s.dinnerrate;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.viewpagerindicator.UnderlinePageIndicator;


public class MainActivity extends FragmentActivity implements View.OnClickListener, SensorEventListener {
    private ImageView gpsButton, friendsButton, myVisitsButton, top20Button;
    UnderlinePageIndicator mIndicator;
    static ViewPager pager = MainActivity.pager;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    Handler sensorHandler;
    Runnable toggleRunnable;

    String[] restuarenter = {"DinnerRate", "Cofoco", "MadKlubben", "Tony's", "Noma", "BLa1", "Bla2", "Bla3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorHandler = new Handler();
        toggleRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    pager.setCurrentItem(3, true);
                }
                catch (Exception ex){
                    Log.d("pager", "sensor thread cant affect main thread even in runnable");
                }

            }
        };
        this.myVisitsButton = (ImageView)findViewById(R.id.my_visits);
        this.friendsButton = (ImageView)findViewById(R.id.friends);
        this.top20Button = (ImageView)findViewById(R.id.top_20);
        this.gpsButton = (ImageView)findViewById(R.id.gps);


        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        myVisitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pager.setCurrentItem(0, true);
            }
        });
        friendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {pager.setCurrentItem(1, true); }});
        top20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2, true);
            }
        });
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(3, true);
            }
        });
/*
        aq.id(R.id.search).clicked(this, "searchClicked");
        aq.id(R.id.settings).clicked(this, "settingsClicked");
        aq.id(R.id.gps).image(R.drawable.gps).visible().clicked(this, "gpsClicked");
        aq.id(R.id.friends).image(R.drawable.friends).visible().clicked(this, "friendsClicked");
        aq.id(R.id.top20).image(R.drawable.top20).visible().clicked(this, "top20Clicked");
        aq.id(R.id.myvisits).image(R.drawable.myvisits).visible().clicked(this, "myvisitsClicked");

*/

        mIndicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
        mIndicator.setFades(false);
        mIndicator.setViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int hyppighed = SensorManager.SENSOR_DELAY_NORMAL;
        mSensorManager.registerListener(this, mAccelerometer, hyppighed);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    public void searchClicked(View b) {


    }
    public void onSensorChanged(SensorEvent e){
        int sensor = e.sensor.getType();
        if (sensor == Sensor.TYPE_ACCELEROMETER){
            double sum = Math.abs(e.values[0]) + Math.abs(e.values[1])+ Math.abs(e.values[2]);
            if (sum > 3 * SensorManager.GRAVITY_EARTH){
                Toast toast = Toast.makeText(getApplicationContext(),"Shake It", Toast.LENGTH_SHORT);
                toast.show();
                /*
                try {
                    sensorHandler.postDelayed(toggleRunnable, 1000);
                }
                catch (Exception ex){
                    Log.d("pager", "sensor thread cant affect main thread");
                }*/
                Intent gps = new Intent(this, Gps.class);
                startActivity(gps);
            }



        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void settingsClicked(View b) {
        Intent set = new Intent(this, Settings.class);
        startActivity(set);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        //Fejler
        if (pager.getCurrentItem() != 1){
            pager.setCurrentItem(pager.getCurrentItem()-1);
        }
    }
        private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return FrontPage.newInstance("FirstFragment, Instance 1");
                case 1:
                    return Friends.newInstance("SecondFragment, Instance 1");
                case 2:
                    return Top20.newInstance("ThirdFragment, Instance 1");

                case 3:
                    return GpsActivity.newInstance("ForthFragment, Instance 2");

                default:
                    return FrontPage.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}