/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapping;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author zixcode
 */
public class DixonsProduct extends Product{
    
      
    public DixonsProduct(){
    super();
    }
    
    
    public DixonsProduct(int pNr, String pCode, String product, String model, String cpu, String ram, String hddType, String capacity,String vga, String info, String price){
        super(pNr,pCode,product,model,cpu,ram,hddType,capacity,vga,info,price);
    }

    /**
     * @return the pNr
     */
    

    @Override
    public String toString(){
        
        return "Product Code : " + getpCode() + "\nBrand : " + getBrand() + " : " + getModel() + "\nCpu : " + getCpu() + "\nRam : " + getRam() + "\nHDD Type : " + getHddType()
                + ", " + getCapacity() + "\nVga : " + getVga() + "\nInfo : " + getInfo() + "\nPrice : " + getPrice()+"\n";
    }
     
   
}
