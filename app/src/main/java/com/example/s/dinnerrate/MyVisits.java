package com.example.s.dinnerrate;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 15-10-2014.
 */


public class MyVisits extends ListFragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private CustomAdapter mAdapter;
    public ArrayList<RowObject> Arr = new ArrayList<RowObject>();

    public static MyVisits newInstance(String text) {

        MyVisits f = new MyVisits();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        setListData();

        Resources res = getResources();
        listView = (ListView)getActivity().findViewById(R.id.list);  // List defined in XML ( See Below )

        mAdapter=new CustomAdapter( getActivity(), Arr,res );
        setListAdapter(mAdapter);


        /*
        mAdapter = new CustomAdapter(getActivity(), android.R.id.list, restuarenter);
        listView.setOnItemClickListener(this);
        listView.setAdapter(mAdapter);
        listView.setDivider(getResources().getDrawable(android.R.drawable.divider_horizontal_bright));
        */

    }
    public void setListData()
    {
        Arr.clear();
        String[] restuarenter = {"DinnerRate", "Cofoco", "MadKlubben", "Tony's", "Noma", "BLa1", "Bla2", "Bla3", "Bla4", "Bla5", "Bla6"};
        int[] images = {0x7f020091,0x7f020092,0x7f020093,0x7f020094,0x7f020095,0x7f020096,0x7f020097,0x7f020098,0x7f020099 };
        for (int i = 0; i < 9; i++) {

            final RowObject row = new RowObject();

            row.setRestuarentName(restuarenter[i]);
            row.setRating("Rating: " + i);
            row.setImage(images[i]);


            Arr.add(row);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
