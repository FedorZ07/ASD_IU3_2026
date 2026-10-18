package ru.bmstu.lab1.task02;

/**
 * Задача 2. Индекс первого вхождения.
 * Вход: массив из n целых чисел и число x.
 * Выход: индекс первого элемента, равного x, или -1, если такого нет.
 */
public class FirstIndexFinder {

    /**
     * Ищет первый элемент, равный x, линейным проходом слева направо.
     *
     * @param arr массив чисел
     * @param x искомое число
     * @return индекс первого вхождения x или -1, если x в массиве нет
     */
    public static int findFirstIndex(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                // нашли первое вхождение, дальше искать не нужно
                return i;
            }
        }
        return -1;
    }
}
