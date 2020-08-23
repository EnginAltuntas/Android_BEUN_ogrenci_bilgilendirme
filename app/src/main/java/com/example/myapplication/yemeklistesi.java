package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class yemeklistesi extends AppCompatActivity {

    List<String> yemekisimleri = new ArrayList<>();
    List<String> yemekisimleri2 = new ArrayList<>();
    List<String> tarihlerlist = new ArrayList<>();
    List<String> bos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemeklistesi);

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

                    //       ================ yemek isimleri
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

                        Button buton = (Button)findViewById(R.id.button1);
                        buton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ListView liste = findViewById(R.id.listView);
                                ArrayAdapter<String> veriadaptor = new ArrayAdapter<>(yemeklistesi.this, android.R.layout.simple_list_item_1, android.R.id.text1, yemekisimleri);
                                liste.setAdapter(veriadaptor);

                            }
                        });

                        Button buton2 = (Button)findViewById(R.id.button2);
                        buton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ListView liste = findViewById(R.id.listView);
                                ArrayAdapter<String> veriadaptor = new ArrayAdapter<>(yemeklistesi.this, android.R.layout.simple_list_item_1, android.R.id.text1, yemekisimleri2);
                                liste.setAdapter(veriadaptor);
                            }
                        });

                    }
                });
            }
        }).start();
    }
}
