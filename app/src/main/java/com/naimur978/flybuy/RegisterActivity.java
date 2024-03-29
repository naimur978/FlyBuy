package com.naimur978.flybuy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.widget.FrameLayout;
/*will inflate signin and signup fragment in the register frame,
we used fragment just to fill in right through the frame simultaneously
 */

public class RegisterActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    public static boolean onResetPasswordFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout = findViewById(R.id.register_framelayout);
        defaultResetFragment(new SignInFragment());

    }

    //override by default , noone called this method below


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(onResetPasswordFragment){
                onResetPasswordFragment = false;
                setFragment(new SignInFragment());
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    private void defaultResetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();//act as an intent
        fragmentTransaction.replace(frameLayout.getId(),fragment);//inflate signin.java(parameter fragment) as like intent
        fragmentTransaction.commit();
    }

    private void setFragment(Fragment fragment) {
        //include getactivity, cz its not from this activity(outside of the group); in contrast with register activity
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(frameLayout.getId(),fragment); //move to register fragment
        fragmentTransaction.commit();
    }
}
