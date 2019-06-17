package com.chengw.observer.utils;


import com.chengw.observer.utils.typeHandler.typeHandlerImpl.DoubleHandler;
import com.chengw.observer.utils.typeHandler.typeHandlerImpl.LongHandler;
import com.chengw.observer.utils.typeHandler.typeHandlerImpl.StringHandler;
import com.chengw.observer.utils.typeHandler.TypeHandler;
import com.chengw.observer.vo.SubjectEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author chengw
 */
public class ExcelUtils   {


    private final static Map<Class<?>, TypeHandler> typeHandlerMap = new HashMap<>();

    static {
        typeHandlerMap.put(Long.class, new LongHandler());
        typeHandlerMap.put(String.class,new StringHandler());
        typeHandlerMap.put(Double.class,new DoubleHandler());
    }

    public static <T> List<T> importExcel(File excel,Class type) throws IOException, IllegalAccessException, InstantiationException {

        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(excel);

        XSSFSheet sheet = workbook.getSheetAt(0);

        List<T> list = new ArrayList<>();

        for(int i = sheet.getFirstRowNum() + 1;i < sheet.getLastRowNum();i++){
            XSSFRow row = sheet.getRow(i);
            Object object = type.newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            Field.setAccessible(fields,true);
            for(int j = row.getFirstCellNum();j < row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                Field field = fields[j];
                Object cellValue = getCellValue(cell, field);
                field.set(object,cellValue);
            }
            list.add((T) object);
        }

        return list;

    }

    private static  Object getCellValue(Cell cell,Field field){

        TypeHandler typeHandler = typeHandlerMap.get(field.getType());
        if(typeHandler == null){
            return null;
        }
        return typeHandler.handler(cell);

    }



    @Test
    public void test() throws IOException, InstantiationException, IllegalAccessException {
        String filePath = "F:/download/";
        File file = new File(filePath + "建设项目成本科目.xlsx");
        List<SubjectEntity> objects = importExcel(file, SubjectEntity.class);
        for(SubjectEntity s:objects){
            System.out.println(s.toString());
        }


    }

}
