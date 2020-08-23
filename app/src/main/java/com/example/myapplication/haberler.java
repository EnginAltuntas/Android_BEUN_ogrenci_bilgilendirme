package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class haberler extends AppCompatActivity {


    List<Broadcast> haberler = new ArrayList<>();
     List<String> metin = new ArrayList<>();
     List<String> metin1 = new ArrayList<>();
    List<String> a1 =new ArrayList<>();
    List<Broadcast> yazi = new ArrayList<Broadcast>();
    List<String> eng = new ArrayList<>();
    int gcc =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haberler);

        TextView sitem= (TextView) findViewById(R.id.link2);
        sitem.setMovementMethod(LinkMovementMethod.getInstance());

        new Thread(new Runnable() {
            @Override
            public void run() {

                ListView liste = findViewById(R.id.listView);

                try {
                    Document document = Jsoup.connect("https://w3.beun.edu.tr").get();
                    Elements asd = document.select("#yanicerik-51 a");
                    Elements asd1 = document.select("#yanicerik-51 div");

                    for (Element element : asd) {
                        String linkHref = element.attr("href");
                        metin.add(linkHref);

                    }

                    for (Element element : asd1) {
                        Broadcast nesne = new Broadcast();
                        nesne.setTime(element.getElementsByClass("ann-single").text());
                        haberler.add(nesne);
                        metin1.add(nesne.getTime());
                        gcc++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

              //          int x = 1;
                        for (int j = 2; j < gcc; j++) {
                            if (j % 3 == 0) {
                                a1.add( metin1.get(j));
                            //    a1.add("w3.beun.edu.tr" + metin.get(x));
                            //    x++;
                            }
                        }

                        // listview tıklanması
                        ListView liste = findViewById(R.id.listView);
                        ArrayAdapter<String> veriadaptor = new ArrayAdapter<>(haberler.this, android.R.layout.simple_list_item_1, android.R.id.text1, a1);
                        liste.setAdapter(veriadaptor);

                        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if(position == 0)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(1));
                                    startActivity(yeniIntent);
                                }
                                if(position == 1)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(2));
                                    startActivity(yeniIntent);
                                }
                                if(position == 2)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(3));
                                    startActivity(yeniIntent);
                                }
                                if(position == 3)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(4));
                                    startActivity(yeniIntent);
                                }
                                if(position == 4)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(5));
                                    startActivity(yeniIntent);
                                }
                                if(position == 5)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(6));
                                    startActivity(yeniIntent);
                                }
                                if(position == 6)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(7));
                                    startActivity(yeniIntent);
                                }
                                if(position == 7)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(8));
                                    startActivity(yeniIntent);
                                }
                                if(position == 8)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(9));
                                    startActivity(yeniIntent);
                                }
                                if(position == 9)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(10));
                                    startActivity(yeniIntent);
                                }
                                if(position == 10)
                                {
                                    Intent yeniIntent =new Intent(haberler.this,sonradan_acilan.class);
                                    yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(11));
                                    startActivity(yeniIntent);
                                }
                            }
                        });
//======================

                    }

                });

            }
            }).start();


        }

    }
