package ru.yandex.tasks;

import javax.swing.plaf.basic.BasicLookAndFeel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task7PrimeNumbers {

    public static void main(String[] args) {
        selfCheck();
        for (int i : findPrimes(25)) {
            System.out.print(i + " ");
        }
    }
    public static int[] findPrimes (int N) {
        /*
         * 2 <= N <= 10^6
         * Выход: отсортированный массив всех простых чисел от 2 до N
         */
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            ans.add(i);
        }
        int offset = 2;
        for (int i = 2; i <= N; i++) {
            if (ans.get(i - offset) == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = i + 1; j <= N; j++) {
                if (ans.get(j - offset) == Integer.MAX_VALUE) {
                    continue;
                }
                if (j % i == 0) {
                    ans.set(j - offset, Integer.MAX_VALUE);
                }
            }
        }
        Iterator<Integer> iterator = ans.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == Integer.MAX_VALUE) {
                iterator.remove();
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }
}
