package com.baizhi.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExportUser {
    public static void main(String[] args) throws IOException {

        //创建Excel表格
        Workbook workbook =  new HSSFWorkbook();
        /*
            时间按格式的调整
        */
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");

        //创建一个工作表
        Sheet sheet = workbook.createSheet("学生信息");
        //设置表格宽度
        //创建一个新行
        Row row = sheet.createRow(0);
        //创建单元格样式表
        CellStyle cellStyle = workbook.createCellStyle();
        //设置样式表样式
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        //创建字体样式表
        Font font = workbook.createFont();
        //设置样式表的格式
        cellStyle.setDataFormat(format);
        //设置字体
        font.setColor(Font.COLOR_RED);
        //设置到样式表
        cellStyle.setFont(font);
        //创建单元格
        Date[] title = {new Date(),new Date(),new Date()};
        //循环添加标题
        for (int i=0;i<title.length;i++){
            sheet.setColumnWidth(i,10000);
            Cell cell = row.createCell(i);
            //将样式设置到单元格
            cell.setCellStyle(cellStyle);
            //将字体设置到单元格
            cell.setCellValue(title[i]);
        }
        //写出磁盘
        FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/皇甫/Desktop/第一个.xls"));
        workbook.write(outputStream);
        outputStream.close();
    }
}
