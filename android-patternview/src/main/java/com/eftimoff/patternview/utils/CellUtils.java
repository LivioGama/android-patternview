package com.eftimoff.patternview.utils;

import com.eftimoff.patternview.cells.Cell;
import com.eftimoff.patternview.cells.CellManager;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class CellUtils {

    private CellUtils() {

    }

    /**
     * Check if the Cell is in the size of the manager.
     * Throw exception if it is not.
     *
     * @param row
     * @param column
     */
    public static void checkRange(int row, int column) {
        if (row < 0) {
            throw new IllegalArgumentException("row must be in range 0-" + (row - 1));
        }
        if (column < 0) {
            throw new IllegalArgumentException("column must be in range 0-" + (row - 1));
        }
    }

    /**
     * Converts a string to a pattern
     *
     * @param string
     * @return
     */
    public static List<Cell> stringToPattern(final String string, final CellManager cellManager) {
        final List<Cell> result = new ArrayList<>();
        if (!TextUtils.isEmpty(string)) {
            final String[] allCells = string.split("&");
            final int length = allCells.length;
            for (int i = 0; i < length; i++) {
                final String[] rowAndColumn = allCells[i].split("-");
                final int row = Integer.valueOf(rowAndColumn[0]);
                final int column = Integer.valueOf(rowAndColumn[1]);
                final Cell cell = cellManager.get(row, column);
                result.add(cell);
            }
        }
        return result;
    }
}
