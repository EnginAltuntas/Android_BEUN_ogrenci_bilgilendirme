package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class sonradan_acilan extends AppCompatActivity {

    List<Broadcast> yazi = new ArrayList<Broadcast>();
    List<String> eng = new ArrayList<>();
    public int gcc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonradan_acilan);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String gelen = getIntent().getStringExtra("mesaj");
                gelen="https://"+gelen;
              //  textView.setText(gelen);

                try {
                    Document document = Jsoup.connect(gelen).get();
                    Elements links = document.select("p");

                    for (Element link : links) {
                        eng.add(link.text());
                        gcc++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListView liste = findViewById(R.id.listView61);
                        ArrayAdapter<String> veriadaptor = new ArrayAdapter<>(sonradan_acilan.this, android.R.layout.simple_list_item_1, android.R.id.text1, eng);
                        liste.setAdapter(veriadaptor);
/*
                        textView.setText(eng.get(0)+"\n\n"+
                                eng.get(1)+"\n\n"+
                                eng.get(2)+"\n\n"+
                                eng.get(3));*/
                    }

                });
            }
        }).start();

    }
}

