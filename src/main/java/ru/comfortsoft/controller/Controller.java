package ru.comfortsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.comfortsoft.service.NumberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Класс Controller - реализует обработку загрузки файла и получение N-го минимального числа.
 *
 * @author shatkovskii_a_v
 * @created 2025-05-05 project TestForConvSoft for
 * @company Удобный Софт
 */
@RestController
@RequestMapping("/api/excel")
public class Controller {
    @Autowired
    private NumberService numberService;  // Зависимость через интерфейс

    @PostMapping("/upload")
    @Operation(summary = "Поиск наименьшего числа")
    public ResponseEntity<Integer> findNthSmallest(
            @Parameter(description = "Путь к *.xlsx файлу")
            @RequestParam String filePath,
            @Parameter(description = "N наименьшее число, которое нужно найти")
            @RequestParam int N) {
        return ResponseEntity.ok(numberService.findNthSmallest(filePath, N));
    }
}
