package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.model.Customer;

public class ExcelExportClass {

	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Customer> listOfCustomer;
    
    public ExcelExportClass(List<Customer> listOfCustomer) {
        this.listOfCustomer = listOfCustomer;
        workbook = new XSSFWorkbook();
    }
    
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "CustomerID", style);      
        createCell(row, 1, "CompanyName", style);       
        createCell(row, 2, "ContactName", style);    
        createCell(row, 3, "ContactTitle", style);
        createCell(row, 4, "Address", style);
        createCell(row, 5, "City", style);
        createCell(row, 6, "Region", style);
        createCell(row, 7, "PostalCode", style);
        createCell(row, 8, "Country", style);
        createCell(row, 9, "Phone", style);
        createCell(row, 10, "Fax", style);
    }
    
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Customer customer : listOfCustomer) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, customer.getCustomerID(), style);
            createCell(row, columnCount++, customer.getCompanyName(), style);
            createCell(row, columnCount++, customer.getContactName(), style);
            createCell(row, columnCount++, customer.getContactTitle(), style);
            createCell(row, columnCount++, customer.getAddress(), style);
            createCell(row, columnCount++, customer.getCity(), style);
            createCell(row, columnCount++, customer.getRegion(), style);
            createCell(row, columnCount++, customer.getPostalCode(), style);
            createCell(row, columnCount++, customer.getCountry(), style);
            createCell(row, columnCount++, customer.getPhone(), style);
            createCell(row, columnCount++, customer.getFax(), style);
        }
    }
    
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
