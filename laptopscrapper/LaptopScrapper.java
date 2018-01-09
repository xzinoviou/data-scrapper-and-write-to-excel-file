/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptopscrapper;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scrapping.DixonsProduct;
import scrapping.Scraper;
import writing.WriteToFile;

/**
 *
 * @author zixcode
 */
public class LaptopScrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
           
        String dixonsUrl = "https://www.kotsovolos.gr/site/computing/laptop-tablet-ipad/notebook-macbook-ultrabook?v=0&10901=41244&10901=41245&1102=39866&1102=46681&1102=39805&flt=all";
          
       Scraper myScraper = Scraper.createInstance();
       myScraper.setUrl(dixonsUrl);
       
       List<DixonsProduct> laptops = myScraper.scrapeDixons();
       
       //if you want to write an xls file       
       WriteToFile wtf1 = new WriteToFile("D:\\Downloads\\K_XLS.xls","kotsovolos",laptops.size(),11);
       wtf1.createExcelFile(laptops);
       
       //if you want to write an xlsx file
       WriteToFile wtf2 = new WriteToFile("D:\\Downloads\\K_XLSX.xlsx","kotsovolos",laptops.size(),11);
       wtf2.createExcelFile(laptops);
       
       
       
       System.out.println("Process Completed");
        
    }
    
}
