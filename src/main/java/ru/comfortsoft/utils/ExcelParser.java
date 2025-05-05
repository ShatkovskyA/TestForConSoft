package ru.comfortsoft.utils;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс ExcelParser - утилитный класс, реализует парсинг *.xlsx файла.
 *
 * @author shatkovskii_a_v
 * @created 2025-05-05 project TestForConvSoft for
 * @company Удобный Софт
 */
@Component
public class ExcelParser {

    /**
     * метод  parseNumbers() -  принмает на вход путь к локальному файлу в формате xlsx считывает числовые значения,
     * и преобразует их в массив интовый.
     *
     * @param filePath
     * @return int[]
     * @throws RuntimeException
     */
    public int[] parseNumbers(String filePath) {
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            List<Integer> numbers = new ArrayList<>();

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
            return numbers.stream().mapToInt(i -> i).toArray();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения *.xlsx файла", e);
        }
    }
}
