package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class yemeklistesigiris extends AppCompatActivity {
    private Button button1;
    List<String> yemekisimleri = new ArrayList<>();
    List<String> yemekisimleri2 = new ArrayList<>();
    List<String> tarihlerlist = new ArrayList<>();
    List<String> giris1 = new ArrayList<>();
    List<String> giris2 = new ArrayList<>();
    List<String> bos = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String sistemTarihiniGetir(String tarihFormati)
    {
        Calendar takvim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(tarihFormati);
        return sdf.format(takvim.getTime());
    }
    String tarih= sistemTarihiniGetir("dd.MM.yy");
    TextView yazi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemeklistesigiris);

        yazi = (TextView) findViewById(R.id.textView4);
        yazi.setText(tarih);

        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent yeniIntent =new Intent(yemeklistesigiris.this,yemeklistesi.class);

                startActivity(yeniIntent);
            }
        });



        new Thread(new Runnable() {
            @Override

            public void run() {
                List<Broadcast> broadcastList = new ArrayList<>();
                try {
                    Document document = Jsoup.connect("https://w3.beun.edu.tr/yemek-listesi.html").get();
                    Elements broadcasts = document.select("#sy div");

                    //       ================

                    Elements links = document.select("tr");
                    ArrayList<String> yemek_isimler = new ArrayList<>();
                    ArrayList<String> trh = new ArrayList<>();

                    String c1 = "0", c2 = "1", c3 = "2", c4 = "3";

                    //       ================ tarih
                    for (Element element : broadcasts) {
                        Broadcast broadcast = new Broadcast();
                        broadcast.setTime(element.getElementsByClass("tarih").text());
                        broadcastList.add(broadcast);
                    }

                    for (Broadcast broadcast : broadcastList) {
                        tarihlerlist.add(broadcast.getTime());
                        //trh.add(broadcast.getTime());
                    }



                    int i=0, gcc=0, donemsayar=1, sayac=0;
                    for (Element link : links) {
                        if(link.text().isEmpty() && sayac==0)
                        {
                            donemsayar=2;
                            gcc=0;
                            sayac++;
                        }
                        if(link.text().length()>100 && donemsayar==1) ;
                        else if(donemsayar==1) {
                            if (i % 4 == 0 || i == 0) {
                                yemekisimleri.add(tarihlerlist.get(gcc));
                                gcc++;
                                i = 0;

                            }
                            i++;
                            if(tarih.equals(tarihlerlist.get(gcc-1))) giris1.add(link.text());
                            yemekisimleri.add(link.text());

                        }
                        if(sayac==1)
                        {
                            bos.add(link.text());
                            sayac=2;
                        }
                        else if(donemsayar==2)
                        {
                            if(link.text().length()>100);
                            else {
                                if (i % 4 == 0 || i == 0) {
                                    yemekisimleri2.add(tarihlerlist.get(gcc));
                                    gcc++;
                                    i = 0;

                                }
                                i++;
                                if(tarih.equals(tarihlerlist.get(gcc-1))) giris2.add(link.text());
                                yemekisimleri2.add(link.text());
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // ekrana yazdırma
                        ListView liste = findViewById(R.id.osman);
                        ArrayAdapter<String> veriadaptor = new ArrayAdapter<>(yemeklistesigiris.this, android.R.layout.simple_list_item_1, android.R.id.text1, giris1);
                        liste.setAdapter(veriadaptor);



                        ListView liste2 = findViewById(R.id.osman2);
                        ArrayAdapter<String> veriadaptor2 = new ArrayAdapter<>(yemeklistesigiris.this, android.R.layout.simple_list_item_1, android.R.id.text1, giris2);
                        liste2.setAdapter(veriadaptor2);


                    }
                });
            }
        }).start();





    }
}
