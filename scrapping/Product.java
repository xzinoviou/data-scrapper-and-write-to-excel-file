/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapping;

/**
 *
 * @author zixcode
 */
public abstract class Product {
    
    private int pNr;    
    private String pCode;
    private String brand;
    private String model;
    private String cpu;
    private String ram;
    private String hddType;
    private String capacity;
    private String vga;
    private String info;
    private String price;
   
    
     public Product(){}
    
    
    public Product(int pNr, String pCode, String product, String model, String cpu, String ram, String hddType, String capacity,String vga, String info, String price){
        this();
        this.pNr = pNr;
        this.pCode = pCode;
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.hddType = hddType;
        this.capacity = capacity;
        this.vga = vga;
        this.info = info;
        this.price = price;
    }
    
    
    

    /**
     * @return the pNr
     */
    public int getpNr() {
        return pNr;
    }

    /**
     * @param pNr the pNr to set
     */
    public void setpNr(int pNr) {
        this.pNr = pNr;
    }

    /**
     * @return the pCode
     */
    public String getpCode() {
        return pCode;
    }

    /**
     * @param pCode the pCode to set
     */
    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the cpu
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * @return the ram
     */
    public String getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * @return the hddType
     */
    public String getHddType() {
        return hddType;
    }

    /**
     * @param hddType the hddType to set
     */
    public void setHddType(String hddType) {
        this.hddType = hddType;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the vga
     */
    public String getVga() {
        return vga;
    }

    /**
     * @param vga the vga to set
     */
    public void setVga(String vga) {
        this.vga = vga;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
    //abstract methods
    public abstract String toString();
}
