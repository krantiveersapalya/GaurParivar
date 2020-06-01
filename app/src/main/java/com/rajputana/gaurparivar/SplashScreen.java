package com.rajputana.gaurparivar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {
    LinearLayout l1,l2;
    Button btnsub;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        btnsub = (Button)findViewById(R.id.buttonsub);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        AnimateBell();
        AnimateBlink();
    }

    public void start(View view) {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void AnimateBell() {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        ImageView imgBell= (ImageView) findViewById(R.id.imgBell);
        imgBell.setImageResource(R.drawable.lion);
        imgBell.setAnimation(shake);
    }

    public void AnimateBlink() {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.blink);
        ImageView imgstar= (ImageView) findViewById(R.id.star);
        imgstar.setImageResource(R.drawable.sparkle);
        imgstar.setAnimation(shake);

        ImageView imgstar1= (ImageView) findViewById(R.id.star1);
        imgstar1.setImageResource(R.drawable.sparkle);
        imgstar1.setAnimation(shake);

        ImageView imgstar2= (ImageView) findViewById(R.id.star2);
        imgstar2.setImageResource(R.drawable.sparkle);
        imgstar2.setAnimation(shake);
    }

}
