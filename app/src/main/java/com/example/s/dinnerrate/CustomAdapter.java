package com.example.s.dinnerrate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 25-10-2014.
 */
public class CustomAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    RowObject tempValues=null;
    int i=0;
    public CustomAdapter(Activity a, ArrayList d,Resources resLocal) {

        activity = a;
        data=d;
        res = resLocal;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder {
        ImageView icon;
        TextView Rating;
        TextView Name;

    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){
            vi = inflater.inflate(R.layout.activity_list, null);

            holder = new ViewHolder();
            holder.Name = (TextView) vi.findViewById(R.id.Name);
            holder.Rating=(TextView)vi.findViewById(R.id.Rating);
            holder.icon=(ImageView)vi.findViewById(R.id.icon);

            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.Name.setText("No Data");

        }
        else
        {

            tempValues=null;
            tempValues = ( RowObject ) data.get( position );

            holder.Name.setText( tempValues.getRestuarentName() );
            holder.Rating.setText( tempValues.getRating() );
            /*
            holder.icon.setImageResource(tempValues.getImage());

            */
            //Log.d("image", Integer.toString(res.getIdentifier(tempValues.getImage(),null,null)));

            holder.icon.setImageDrawable(res.getDrawable(tempValues.getImage()));


        }
        return vi;
    }

}



