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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class duyurular extends AppCompatActivity {

    List<Broadcast> broadcastList = new ArrayList<>();
    List<String> a1 =new ArrayList<>();
    List<String> metin = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyurular);

        TextView sitem= findViewById(R.id.textView5);
        sitem.setMovementMethod(LinkMovementMethod.getInstance());


       new Thread(new Runnable() {
           @Override
           public void run() {
               ListView liste =findViewById(R.id.listView);

               try {
                   Document document = Jsoup.connect("https://w3.beun.edu.tr").get();
                   Elements broadcasts = document.select("#yanicerik-52 div");
                   Elements asd = document.select("#yanicerik-52 a");

                   for (Element element : asd) {
                       String linkHref = element.attr("href"); // "http://example.com/"
                       metin.add(linkHref);
                       //             System.out.println("w3.beun.edu.tr"+linkHref);
                   }

                   for (Element element : broadcasts) {
                       Broadcast broadcast = new Broadcast();
                       broadcast.setTime(element.getElementsByClass("ann-single").text());
                       broadcastList.add(broadcast);
                   }

           } catch (Exception e) {
                   e.printStackTrace();
               }

               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       int i=0; // 1. yi yazdırma
                       int j=0;
                       for (Broadcast broadcast : broadcastList) {

                              if(j!=0) {
                                  if (i % 3 == 0) a1.add(broadcast.getTime());

                              }
                              i++;
                              j++;
                       }


                       ListView liste =findViewById(R.id.listView);
                       ArrayAdapter<String> veriadaptor= new ArrayAdapter<>(duyurular.this, android.R.layout.simple_list_item_1,android.R.id.text1,a1);
                       liste.setAdapter(veriadaptor);

                       liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                           @Override
                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                               if(position == 0)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(1));
                                   startActivity(yeniIntent);
                               }
                               if(position == 1)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(2));
                                   startActivity(yeniIntent);
                               }
                               if(position == 2)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(3));
                                   startActivity(yeniIntent);
                               }
                               if(position == 3)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(4));
                                   startActivity(yeniIntent);
                               }
                               if(position == 4)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(5));
                                   startActivity(yeniIntent);
                               }
                               if(position == 5)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(6));
                                   startActivity(yeniIntent);
                               }
                               if(position == 6)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(7));
                                   startActivity(yeniIntent);
                               }
                               if(position == 7)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(8));
                                   startActivity(yeniIntent);
                               }
                               if(position == 8)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(9));
                                   startActivity(yeniIntent);
                               }
                               if(position == 9)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(10));
                                   startActivity(yeniIntent);
                               }
                               if(position == 10)
                               {
                                   Intent yeniIntent =new Intent(duyurular.this,sonradan_acilan.class);
                                   yeniIntent.putExtra("mesaj","w3.beun.edu.tr"+metin.get(11));
                                   startActivity(yeniIntent);
                               }
                           }
                       });


                   }
               });
           }

}).start();
    }

}