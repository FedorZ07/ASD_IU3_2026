package ru.bmstu.lab1.task02;

import java.util.Scanner;

/**
 * Задача 2. Индекс первого вхождения.
 * Ввод: число n, затем n целых чисел, затем число x.
 * Вывод: индекс первого элемента, равного x, или -1.
 */
public class Main {

    /**
     * Читает массив и число x с клавиатуры и выводит индекс первого вхождения x.
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
        int x = scanner.nextInt();

        System.out.println(FirstIndexFinder.findFirstIndex(arr, x));
    }
}
