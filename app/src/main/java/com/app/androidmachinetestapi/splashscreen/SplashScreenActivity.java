package com.app.androidmachinetestapi.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.app.androidmachinetestapi.MainActivity;
import com.app.androidmachinetestapi.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Handler for time delay for splash screen
        long splashTimeDelay = 3000L;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
                overridePendingTransition(0, 0);
            }
        }, splashTimeDelay);

    }
}