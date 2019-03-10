package com.baizhi.test;

import com.baizhi.entity.Admin;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PoiTest {
    public List<Admin> test1(){
        List<Admin> admins = new ArrayList<Admin>();
        admins.add(new Admin("1","皇甫","123456"));
        admins.add(new Admin("2","皇甫","123456"));
        admins.add(new Admin("3","皇甫","123456"));
        admins.add(new Admin("4","皇甫","123456"));
        admins.add(new Admin("5","皇甫","123456"));
        admins.add(new Admin("6","皇甫","123456"));
        admins.add(new Admin("7","皇甫","123456"));
        admins.add(new Admin("8","皇甫","123456"));
        admins.add(new Admin("9","皇甫","123456"));
        admins.add(new Admin("10","皇甫","123456"));
        admins.add(new Admin("11","皇甫","123456"));
        admins.add(new Admin("12","皇甫","123456"));
        admins.add(new Admin("13","皇甫","123456"));
        admins.add(new Admin("14","皇甫","123456"));
        admins.add(new Admin("15","皇甫","123456"));
        admins.add(new Admin("16","皇甫","123456"));
        admins.add(new Admin("17","皇甫","123456"));
        admins.add(new Admin("18","皇甫","123456"));
        admins.add(new Admin("19","皇甫","123456"));
        admins.add(new Admin("20","皇甫","123456"));
        admins.add(new Admin("21","皇甫","123456"));
        admins.add(new Admin("22","皇甫","123456"));
        admins.add(new Admin("23","皇甫","123456"));
        admins.add(new Admin("24","皇甫","123456"));
        admins.add(new Admin("25","皇甫","123456"));
        admins.add(new Admin("26","皇甫","123456"));
        admins.add(new Admin("27","皇甫","123456"));
        admins.add(new Admin("28","皇甫","123456"));
        admins.add(new Admin("29","皇甫","123456"));
        admins.add(new Admin("30","皇甫","123456"));
        admins.add(new Admin("31","皇甫","123456"));
        admins.add(new Admin("32","皇甫","123456"));
        admins.add(new Admin("33","皇甫","123456"));
        admins.add(new Admin("34","皇甫","123456"));
        admins.add(new Admin("35","皇甫","123456"));
        admins.add(new Admin("36","皇甫","123456"));
        admins.add(new Admin("37","皇甫","123456"));
        admins.add(new Admin("38","皇甫","123456"));
        admins.add(new Admin("39","皇甫","123456"));
        admins.add(new Admin("40","皇甫","123456"));
        admins.add(new Admin("41","皇甫","123456"));
        admins.add(new Admin("42","皇甫","123456"));
        admins.add(new Admin("43","皇甫","123456"));
        admins.add(new Admin("44","皇甫","123456"));
        admins.add(new Admin("45","皇甫","123456"));
        return admins;
    }

    @Test
    public void test2() throws IOException {
        //创建数据源
        List<Admin> admins = this.test1();
        System.out.println(admins.get(0));
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("管理员账户表");
        //创建样式表
        CellStyle cellStyle = workbook.createCellStyle();
        //创建样式
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        //创建标题
        String[] titles = {"管理员编号","管理员名字","管理员密码"};
        //循环创建标题行
        Row row = sheet.createRow(0);
        for(int i=0;i<titles.length;i++){
            //管理工作表列宽
            sheet.setColumnWidth(i,8000);
            //创建列
            Cell cell = row.createCell(i);
            //设置样式
            cell.setCellStyle(cellStyle);
            //填充列数据
            cell.setCellValue(titles[i]);
        }
        //填充数据
        for(int i=1;i<=admins.size();i++){
            Row r = sheet.createRow(i);
            Cell c0 = r.createCell(0);
            c0.setCellStyle(cellStyle);
            c0.setCellValue(admins.get(i-1).getId());
            Cell c1 = r.createCell(1);
            c1.setCellStyle(cellStyle);
            c1.setCellValue(admins.get(i-1).getName());
            Cell c2 = r.createCell(2);
            c2.setCellStyle(cellStyle);
            c2.setCellValue(admins.get(i-1).getPassword());

        }
        //标题行创建完成写出磁盘
        FileOutputStream outputStream = new FileOutputStream("C:/Users/皇甫/Desktop/第一个.xls");
        workbook.write(outputStream);
        outputStream.close();
    }

    /*用户的导入*/
    @Test
    public void test3() throws IOException {
        List<Admin> admins = new ArrayList<Admin>();
        //创建工作表对象
        Workbook w = new HSSFWorkbook(new FileInputStream(new File("C:/Users/皇甫/Desktop/第一个.xls")));
        //创建工作簿对象
        Sheet rows = w.getSheet("管理员账户表");
        for(int i=1;i<=rows.getLastRowNum();i++){
            Admin admin = new Admin();
            //拿到对应的行
            Row row = rows.getRow(i);
            //拿到行中的列
            Cell cell = row.getCell(0);
            String adminId = cell.getStringCellValue();
            Cell cell1 = row.getCell(1);
            String adminName = cell1.getStringCellValue();
            Cell cell2 = row.getCell(2);
            String adminPassword = cell2.getStringCellValue();
            admin.setId(adminId);
            admin.setName(adminName);
            admin.setPassword(adminPassword);
            admins.add(admin);

        }

        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
}
