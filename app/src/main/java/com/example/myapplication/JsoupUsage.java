package com.example.myapplication;

import com.example.myapplication.Broadcast;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUsage {

    public static void main(String[] args) {
        /* etkinlikler


        List<Broadcast> etkinlikler = new ArrayList<>();
        List<String> metin = new ArrayList<>();
        List<String> metin1 = new ArrayList<>();
        List<String> tarih = new ArrayList<>();
        try{
            Document document = Jsoup.connect("https://w3.beun.edu.tr/tum-etkinlikler.html").get();
            Elements asd = document.select("#anaicerik a");
            Elements asd1 = document.select("#anaicerik div");

            for(Element element : asd){
                String linkHref = element.attr("href"); // "http://example.com/"
                metin.add(linkHref);
            }
            for(Element element : asd1){
                Broadcast nesne = new Broadcast();
                nesne.setTime(element.getElementsByClass("col-90 1").text());
                metin1.add(nesne.getTime());
            }
            for(Element element : asd1){
                Broadcast nesne = new Broadcast();
                nesne.setTime(element.getElementsByClass("col-10").text());
                tarih.add(nesne.getTime());
            }
            int x=0;
            for(int j=0;j<51;j++)
            {
                if(j%3==0)
                {
                    System.out.println(tarih.get(j)+" tarihli haber  "+metin1.get(j));
             //       System.out.println("site :  w3.beun.edu.tr"+metin.get(x));
                    x++;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/

/*

        //  HABERLER
        List<Broadcast> haberler = new ArrayList<>();
        List<String> metin = new ArrayList<>();
        List<String> metin1 = new ArrayList<>();
        try{
            Document document = Jsoup.connect("https://w3.beun.edu.tr").get();
            Elements asd = document.select("#yanicerik-51 a");
            Elements asd1 = document.select("#yanicerik-51 div");

            for(Element element : asd){
                String linkHref = element.attr("href"); // "http://example.com/"
                metin.add(linkHref);
   //             System.out.println("w3.beun.edu.tr"+linkHref);
            }
            for(Element element : asd1){
                Broadcast nesne = new Broadcast();
                nesne.setTime(element.getElementsByClass("ann-single").text());
                haberler.add(nesne);
                metin1.add(nesne.getTime());
            }

int x=1;
            for(int j=2;j<31;j++)
            {
                if(j%3==0)
                {
                    System.out.println("haber  "+metin1.get(j));
                    System.out.println("site :  w3.beun.edu.tr"+metin.get(x));
                    x++;
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/
/*
        //  HABERLER
        List<Broadcast> haberler = new ArrayList<>();
        try{
            Document document = Jsoup.connect("https://w3.beun.edu.tr").get();
            Elements asd = document.select("#yanicerik-51 div");

            for(Element element : asd){
                Broadcast nesne = new Broadcast();
                nesne.setTime(element.getElementsByClass("ann-single").text());
                haberler.add(nesne);
            }
            for(Broadcast i : haberler)
            {
                System.out.println(i.getTime());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/

// ========  DUYURULAR
/*
        List<Broadcast> broadcastList = new ArrayList<>();

        try {
            Document document = Jsoup.connect("https://w3.beun.edu.tr").get();
            Elements broadcasts = document.select("#yanicerik-52 div");

            for (Element element : broadcasts) {
                Broadcast broadcast = new Broadcast();
                broadcast.setTime(element.getElementsByClass("ann-single").text());
                broadcastList.add(broadcast);
            }
            int i=0; // 1. yi yazdırma
            for (Broadcast broadcast : broadcastList) {
                if(i!=0) System.out.println(broadcast.getTime());
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
/*
            // --   YEMEK LİSTESİ
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

                trh.add(broadcast.getTime());
            }

            //       ================ yemek isimleri
            for (Element link : links) {
                yemek_isimler.add(link.text());
            }
            int gcc = 0, j = 0;
            // ekrana yazdırma
            for (int i = 0; i < 179; i++) {

                if (gcc % 4 == 0 || gcc == 0) {
                    if (j == 21) j = 0;
                    System.out.println("tarih:" + trh.get(j));
                    gcc = 0;
                    j++;
                }

                if (yemek_isimler.get(i).substring(0, 1).equals(c1) ||
                        yemek_isimler.get(i).substring(0, 1).equals(c2) ||
                        yemek_isimler.get(i).substring(0, 1).equals(c3) ||
                        yemek_isimler.get(i).substring(0, 1).equals(c4)) {
                    i++;
                }
                if (i == 88) i++;

                System.out.println(i + " -*- " + yemek_isimler.get(i));
                gcc++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/

   /*     List<Broadcast> yazi = new ArrayList<Broadcast>();
        List<String> eng = new ArrayList<>();
        int gcc=0;
        try {
            Document document = Jsoup.connect("https://w3.beun.edu.tr/haberler/3799/rektorumuz-almanyada-5-issa-turk-universiteleri-tanitim-fuarina-katildi.html").get();
// sayfalar arası veri taşıma ile sayfa linkini al
            Elements asd1 = document.select("#anaicerik-51 div");


            for (Element element : asd1) {
                //            Broadcast nesne = new Broadcast();
                //          nesne.setTime(element.getElementsByClass("col-70").text());
                String paragraf = element.attr("p");
                //   yazi.add(nesne);
                //    eng.add(nesne.getTime());
                eng.add(paragraf);
                gcc++;
            }

            for(int i=0;i<gcc;i++)
            {
                System.out.println(eng.get(gcc));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/





        }
    }