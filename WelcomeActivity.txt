package com.example.android.myapp;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "WelcomeActivity";
    private ViewPager mSlider;
    private int [] layouts = {R.layout.activity_welcome,R.layout.activity_information};
    ImageView imageView;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (Build.VERSION.SDK_INT>19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_welcome);

        mSlider = (ViewPager)findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(layouts,this);
        mSlider.setAdapter(sliderAdapter);

        imageView = (ImageView)findViewById(R.id.route);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Onclick");
            }
        });
    }
}
