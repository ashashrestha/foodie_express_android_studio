package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ocem.foodieexpress.R;

public class LoadingActivity extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

     ImageView imgSplash1 = findViewById(R.id.imgSplash1);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.splash_transition);
        imgSplash1.startAnimation(anim);
        final Intent intent = new Intent(this, LoginActivity.class);
        Thread timer = new Thread(){
            public void run () {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
 }
}