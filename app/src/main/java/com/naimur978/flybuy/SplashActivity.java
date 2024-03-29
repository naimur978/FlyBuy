package com.naimur978.flybuy;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();

        SystemClock.sleep(500);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser == null)
        {
            startActivity(new Intent(SplashActivity.this,RegisterActivity.class));
            finish();
        }else{
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
        }
    }
}
