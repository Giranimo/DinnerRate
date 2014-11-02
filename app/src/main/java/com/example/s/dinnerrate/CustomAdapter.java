package com.example.s.dinnerrate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 25-10-2014.
 */
public class CustomAdapter extends ArrayAdapter {
    Context context;
    String[] restuarenter = {"DinnerRate", "Cofoco", "MadKlubben", "Tony's", "Noma", "BLa1", "Bla2", "Bla3"};
    String[] ratingList = {"1", "2", "3", "4", "5", "6", "7", "8"};
    public CustomAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView Rating;
        TextView Name;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        String rest = restuarenter[position];
        String rate = ratingList[position];

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_list, null);
            holder = new ViewHolder();
            //holder.Rating = (TextView) convertView.findViewById(R.id.Rating);
            holder.Name = (TextView) convertView.findViewById(R.id.Name);

            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

            holder.Name.setText(rest);

            //holder.Rating.setText(rate);

        //holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }

}

