package com.chengw.observer.utils.typeHandler.typeHandlerImpl;

import com.chengw.observer.utils.typeHandler.TypeHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class DoubleHandler implements TypeHandler {
    @Override
    public Object handler(Cell cell) {
        CellType cellType = cell.getCellType();

        if(cellType.equals(CellType.NUMERIC)){
            return cell.getNumericCellValue();
        }else if(cellType.equals(CellType.STRING)){
            try {
                return  Double.valueOf( cell.getStringCellValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
