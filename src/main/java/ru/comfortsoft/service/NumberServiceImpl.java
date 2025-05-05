package ru.comfortsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.comfortsoft.utils.ExcelParser;

/**
 * Класс NumberServiceImpl - реализает метод интерфейса NumberService по условию задачи.
 *
 * @author shatkovskii_a_v
 * @created 2025-05-05 project TestForConvSoft for
 * @company Удобный Софт
 */
@Service
public class NumberServiceImpl implements NumberService {
    @Autowired
    private ExcelParser excelParser;

    /**
     * метод findNthSmallest() - базовый от интерфейса.
     *
     * @return quickSelect
     */
    @Override
    public int findNthSmallest(String filePath, int N) {
        int[] numbers = excelParser.parseNumbers(filePath);
        return quickSelect(numbers, 0, numbers.length - 1, N - 1);
    }

    /**
     * метод quickSelect() - поиск k-го наименьшего элемента в массиве.
     *
     * @return quickSelect
     */
    private int quickSelect(int[] nums, int left, int right, int k) {
        // базовый случай
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        // тут сравниваем индексы массива
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    /**
     * метод partition() - делит массив на две части.
     *
     * @return i
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    /**
     * метод swap() - меняет значения местами.
     *
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
