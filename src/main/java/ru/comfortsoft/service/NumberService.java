package ru.comfortsoft.service;

/**
 * Интерфейс NumberService - представляет метод по условию ТЗ.
 *
 * @author shatkovskii_a_v
 * @created 2025-05-05 project TestForConvSoft for
 * @company Удобный Софт
 */
public interface NumberService {

    /**
     * метод findNthSmallest() -  принмает на вход путь к локальному файлу в формате xlsx и число N.
     *
     * @param filePath
     * @param N
     */
    int findNthSmallest(String filePath, int N);
}
