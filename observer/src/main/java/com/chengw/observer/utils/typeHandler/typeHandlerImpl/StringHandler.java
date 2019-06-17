package com.chengw.observer.utils.typeHandler.typeHandlerImpl;

import com.chengw.observer.utils.typeHandler.TypeHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class StringHandler implements TypeHandler {
    @Override
    public Object handler(Cell cell) {
        CellType cellType = cell.getCellType();

        if(cellType.equals(CellType.NUMERIC)){
            return  String.valueOf(cell.getNumericCellValue()) ;
        }else if(cellType.equals(CellType.STRING)){
            try {
                return cell.getStringCellValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
