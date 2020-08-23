package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent yeniIntent =new Intent(menu.this,MainActivity.class);

                startActivity(yeniIntent);
            }
        });

        button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yenIntent =new Intent(menu.this,haberler.class);

                startActivity(yenIntent);
            }
        });

        button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yeniIntent =new Intent(menu.this,duyurular.class);

                startActivity(yeniIntent);
            }
        });

        button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yeniIntent =new Intent(menu.this,yemeklistesigiris.class);

                startActivity(yeniIntent);
            }
        });
    }
}
