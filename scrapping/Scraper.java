/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapping;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author zixcode
 */
public class Scraper{
    
 private static Scraper instance;; 
 private String url;
 private Document doc;
 private Element productEl;
 
 protected Scraper(){}
 
 
 //singleton constructor
 public static Scraper createInstance(){
     if(instance==null)
         return new Scraper();
     
     return instance;
 }
 
 
 public void setUrl(String url){
     this.url = url;
 }
 
 
 public List<DixonsProduct> scrapeDixons(){
     
     List<DixonsProduct> list = new ArrayList<DixonsProduct>();
     try{
                  
         doc = Jsoup.connect(url).get();
         
                
         
         for(int i=0; i<doc.getElementsByClass("productData").size(); i++){
             
            productEl = doc.getElementsByClass("productData").get(i);
         
             DixonsProduct dp = new DixonsProduct();
             
             dp.setpNr(i);
             
             dp.setpCode(productEl.getElementsByClass("code").text());
             
             int splitter = productEl.getElementsByTag("h4").text().indexOf(" ");
             
             dp.setBrand(productEl.getElementsByTag("h4").text().substring(0,splitter));
             
             dp.setModel(productEl.getElementsByTag("h4").text().substring(splitter,productEl.getElementsByTag("h4").text().length()).trim());
             
             StringBuilder sb = new StringBuilder();
             
                for(int j=0; j<productEl.getElementsByTag("ul").get(0).getElementsByTag("li").size(); j++){
                    
                    switch(j){
                        
                        case 0:
                            sb.append(productEl.getElementsByTag("ul").get(0).getElementsByTag("li").get(j).text());
                            splitter = sb.lastIndexOf(":");
                            dp.setCpu(sb.substring(splitter+1,sb.length()).trim());
                            sb.setLength(0);
                            break;
                            
                        case 1:
                            sb.append(productEl.getElementsByTag("ul").get(0).getElementsByTag("li").get(j).text());
                            splitter = sb.lastIndexOf(":");
                            dp.setRam(sb.substring(splitter+1,sb.length()).trim());
                            sb.setLength(0);
                            break;
                            
                        case 2:
                            sb.append(productEl.getElementsByTag("ul").get(0).getElementsByTag("li").get(j).text());
                            splitter = sb.lastIndexOf(":");
                            dp.setHddType(sb.substring(splitter+1,sb.length()).trim());
                            sb.setLength(0);
                            break;
                            
                        case 3:
                            sb.append(productEl.getElementsByTag("ul").get(0).getElementsByTag("li").get(j).text());
                            splitter = sb.lastIndexOf(":");
                            dp.setCapacity(sb.substring(splitter+1,sb.length()).trim());
                            sb.setLength(0);
                            break;
                            
                        case 4:
                            sb.append(productEl.getElementsByTag("ul").get(0).getElementsByTag("li").get(j).text());
                            splitter = sb.lastIndexOf(":");
                            dp.setVga(sb.substring(splitter+1,sb.length()).trim());
                            sb.setLength(0);
                            break;
                        
                    }
                }
           
                dp.setInfo(productEl.getElementsByClass("description").get(0).getElementsByTag("p").get(0).text());
                                
                dp.setPrice(doc.getElementsByClass("price").get(i).text());

         
         list.add(dp);
         
         }

     }
     catch(IOException e){
         System.out.println("IO Exception");
         e.printStackTrace();
     }
     
     
     return list;
 }
 
 
    
}
