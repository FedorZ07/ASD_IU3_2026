package ru.bmstu.lab1.task14;

import java.util.Scanner;

/**
 * Задача 14. Сортировка вставками.
 * Ввод: число n, затем n целых чисел.
 * Вывод: элементы массива по невозрастанию через пробел.
 */
public class Main {

    /**
     * Читает массив с клавиатуры, сортирует его вставками и выводит.
     *
     * @param args не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        InsertionSort.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
