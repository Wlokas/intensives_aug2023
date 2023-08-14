package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3InsertionSort {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой вставками!) numbers
         */
        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);
            int j = i - 1;
            while (i >= 0) {
                if (value < numbers.get(i)) {
                    numbers.set(i + 1, numbers.get(i));
                } else {
                    break;
                }
                i--;
            }
            numbers.set(i + 1, value);
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
