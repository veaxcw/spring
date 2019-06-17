package com.chengw.observer.utils.typeHandler;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

public interface TypeHandler {


    /**
     * 根据单元格数据类型转化为对应的实体类中的字段
     * @param cell
     * @return
     */
    Object handler(Cell cell);

}
