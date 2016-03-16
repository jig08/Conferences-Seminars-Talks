package com.example.jigyasa.jigyasagrover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/**
 * Created by jigyasa on 12/3/16.
 */

public class SplashScreen extends AppCompatActivity {

    private Thread mSplashThread;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        ScaleAnimation scaleAnim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnim.setDuration(2000);
        scaleAnim.setStartOffset(400);
        scaleAnim.setFillAfter(true);

        TextView header = (TextView) findViewById(R.id.header);
        header.setVisibility(View.VISIBLE);
        header.setAnimation(scaleAnim);

        final SplashScreen splashScreen = this;

        // The thread to wait for splash screen events
        mSplashThread =  new Thread(){

            public void run(){
                try {
                    synchronized(this){
                        // Wait given period of time or exit on touch
                        wait(4500);
                    }
                }
                catch(InterruptedException ex){
                }

                finish();

                // Run next activity
                Intent intent = new Intent();

                intent.setClass(splashScreen, MainActivity.class);
                startActivity(intent);
            }
        };

        mSplashThread.start();
    }
}


