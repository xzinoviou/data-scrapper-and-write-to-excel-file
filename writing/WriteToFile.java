/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import scrapping.DixonsProduct;
import scrapping.Product;

/**
 *
 * @author zixcode
 */
public class WriteToFile {
    
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;
    private int rows;
    private int columns;
    
    private String sheetName;
    
    
    //default constructor
    public WriteToFile(String filePath){
        this.filePath = filePath;
        typeOfWorkbook(filePath);
                       
    }
    
    
    //constructor w/values
    public WriteToFile(String filePath,String sheetName,int rows,int columns){
        this(filePath);
        this.sheetName = sheetName;
        this.rows = rows;
        this.columns = columns;
    }
    
    //helpers
    public void createExcelFile(List<DixonsProduct> list) throws IOException{
        
       
            workbook = typeOfWorkbook(filePath);
            sheet = typeOfSheet();
            Row header = typeOfRow(0);
            
            header.createCell(0).setCellValue("#");
            header.createCell(1).setCellValue("Product Code");
            header.createCell(2).setCellValue("Brand");
            header.createCell(3).setCellValue("Model");
            header.createCell(4).setCellValue("CPU");
            header.createCell(5).setCellValue("RAM");
            header.createCell(6).setCellValue("Disk Type");
            header.createCell(7).setCellValue("Disk Capacity");
            header.createCell(8).setCellValue("Vga");
            header.createCell(9).setCellValue("Description");
            header.createCell(10).setCellValue("Price");
            
            
            for(int i=1; i<rows+1; i++){
                
                row = typeOfRow(i);
                
                for(int j=0; j<columns; j++){
                    
                    cell = typeOfCell(j);
                    
                    switch(j){
                        
                        case 0:
                            cell.setCellValue(list.get(i-1).getpNr()+1);
                            break;
                            
                        case 1:
                            cell.setCellValue(list.get(i-1).getpCode());
                            break;
                            
                        case 2:
                            cell.setCellValue(list.get(i-1).getBrand());
                            break;
                            
                        case 3:
                            cell.setCellValue(list.get(i-1).getModel());
                            break;
                            
                        case 4:
                            cell.setCellValue(list.get(i-1).getCpu());
                            break;
                            
                        case 5:
                            cell.setCellValue(list.get(i-1).getRam());
                            break;
                            
                        case 6:
                            cell.setCellValue(list.get(i-1).getHddType());
                            break;
                            
                        case 7:
                            cell.setCellValue(list.get(i-1).getCapacity());
                            break;
                            
                        case 8:
                            cell.setCellValue(list.get(i-1).getVga());
                            break;
                            
                        case 9:
                            cell.setCellValue(list.get(i-1).getInfo());
                            break;
                            
                        case 10:
                            cell.setCellValue(list.get(i-1).getPrice());
                            break;
                     
                    }
                }
            }//end of for loops
            
            FileOutputStream fout = new FileOutputStream(filePath);
            workbook.write(fout);
            
            workbook.close();
            
            fout.flush();
            fout.close();
            
            
    }
 
    
    //check which type of workbook is it
    public Workbook typeOfWorkbook(String filePath){
        if(filePath.endsWith("xls"))
            return new HSSFWorkbook();
        
        else if(filePath.endsWith("xlsx"))
            return new XSSFWorkbook();
        
        else
            return null;            
    }
    
    //check type of Sheet
    public Sheet typeOfSheet(){
        
        if(workbook instanceof HSSFWorkbook)
            return (HSSFSheet) workbook.createSheet(sheetName);
        
        else
            return (XSSFSheet) workbook.createSheet(sheetName);
    }
    
    
   //type of row
    public Row typeOfRow(int x){
        if(workbook instanceof HSSFWorkbook)
            return (HSSFRow) sheet.createRow(x);
        
        else
            return (XSSFRow) sheet.createRow(x);
    }
    
    //type of cell
    public Cell typeOfCell(int x){
        
        if(workbook instanceof HSSFWorkbook)
            return (HSSFCell) row.createCell(x);
        
        else
            return (XSSFCell) row.createCell(x);
    }
    
   
    
}
