package com.lekai.root.imute;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by root on 5/24/17.
 */

public class TableAdapter extends BaseAdapter {
    Context myContext;
    public TableAdapter(Context context){
        myContext = context;
    }
    @Override
    public int getCount() {
        return 84;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) parent.findViewById(R.id.table_color);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(80, 80));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(R.mipmap.ic_launcher);
        return imageView;
    }
}
