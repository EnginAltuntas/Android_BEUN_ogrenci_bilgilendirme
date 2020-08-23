package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class GirisActivity extends AppCompatActivity {

    private ImageView ımageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);


        ımageView=findViewById(R.id.imageView2);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.an);
        ImageView girislogo = findViewById(R.id.imageView2);
        anim.reset();
        girislogo.clearAnimation();
        girislogo.startAnimation(anim);
        // Splash
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(GirisActivity.this, menu.class);
                startActivity(i);

                finish();
            }
        }, 2000);

    }
}
