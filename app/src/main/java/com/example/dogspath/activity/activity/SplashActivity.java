package com.example.dogspath.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dogspath.R;
import com.example.dogspath.activity.activity.utils.ConstantClass;
import com.example.dogspath.activity.activity.utils.SharedPrefrence;

public class SplashActivity extends AppCompatActivity {
ImageView imageview;
    Handler handler;
    SharedPrefrence yourprefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageview=findViewById(R.id.image);
        yourprefrence=SharedPrefrence.getInstance(this);
        Glide.with(this).load(R.drawable.image).into(imageview);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (yourprefrence.getData(ConstantClass.LOGIN_STATUS).equals("valid"))
                {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                 else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },3000);
    }
}