package com.example.android.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SliderAdapter extends PagerAdapter {


    private static final String TAG = "SliderAdapter";
    private int [] layouts;
    private LayoutInflater layoutInflater;
    private Context context;

    public SliderAdapter(int [] layouts,Context context){

        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        Log.d(TAG,"getCount" );
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.d(TAG,"isViewFromObject" );
        return view == object;
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        Log.d(TAG,"instantiateItem" );
        View view = layoutInflater.inflate(layouts[position], container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        Log.d(TAG,"destroyItem" );
        View View = (View) object;
        container.removeView(View);
    }
}
