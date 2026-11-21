package ru.bmstu.lab2;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Задача 1A. Очередь с приоритетом на основе минимальной двоичной кучи.
 * Элементы хранятся в расширяемом массиве и сравниваются в естественном порядке.
 *
 * @param <T> тип элементов, которые можно сравнивать
 */
public class PriorityQueueCustom<T extends Comparable<? super T>> {
    private static final int INITIAL_CAPACITY = 8;

    private Object[] elements;
    private int size;

    /** Создаёт пустую очередь с начальной ёмкостью массива. */
    public PriorityQueueCustom() {
        elements = new Object[INITIAL_CAPACITY];
    }

    /**
     * Добавляет элемент за O(log n) в худшем случае.
     *
     * @param item добавляемый элемент (не null)
     * @throws NullPointerException если элемент равен null
     */
    public void add(T item) {
        Objects.requireNonNull(item, "Элемент не должен быть null");
        ensureCapacity();
        elements[size] = item;
        siftUp(size);
        size++;
    }

    /**
     * Удаляет и возвращает минимальный элемент за O(log n).
     *
     * @return минимальный элемент
     * @throws NoSuchElementException если очередь пуста
     */
    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        T minimum = elementAt(0);
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        if (size > 0) {
            siftDown(0);
        }
        return minimum;
    }

    /**
     * Возвращает минимум без удаления за O(1).
     *
     * @return минимальный элемент или null для пустой очереди
     */
    public T peek() {
        return isEmpty() ? null : elementAt(0);
    }

    /**
     * Возвращает число элементов за O(1).
     *
     * @return число элементов
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуста ли очередь, за O(1).
     *
     * @return true, если элементов нет
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        Object[] grown = new Object[elements.length * 2];
        System.arraycopy(elements, 0, grown, 0, size);
        elements = grown;
    }

    // Поднимаем элемент, пока он меньше своего родителя.
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (elementAt(parent).compareTo(elementAt(index)) <= 0) {
                return;
            }
            swap(parent, index);
            index = parent;
        }
    }

    // Опускаем элемент, меняя его с меньшим из двух потомков.
    private void siftDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            int right = left + 1;
            int smaller = left;
            if (right < size && elementAt(right).compareTo(elementAt(left)) < 0) {
                smaller = right;
            }
            if (elementAt(index).compareTo(elementAt(smaller)) <= 0) {
                return;
            }
            swap(index, smaller);
            index = smaller;
        }
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        return (T) elements[index];
    }

    private void swap(int first, int second) {
        Object temporary = elements[first];
        elements[first] = elements[second];
        elements[second] = temporary;
    }
}
