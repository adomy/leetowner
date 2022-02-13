package leetcode.editor.com.dsalgo;

import java.util.Arrays;

/**
 * TODO
 *
 * @ClassName MyArrayList
 * @Author ChaoBryant
 * @Version 1.0.0
 * @CreateTime 2022-02-12 11:00
 */
public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * array
     */
    private Object[] array;

    /**
     * list capacity
     */
    private int capacity;

    /**
     * list size
     */
    private int size;

    /**
     *
     */
    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * @param size
     */
    public MyArrayList(int size) {
        this.array = new Object[size];
    }

    /**
     * @param o
     */
    public void add(Object o) {
        if (size == capacity) {
            grow(size + 1);
        }

        array[size] = o;
        size++;
    }

    /**
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        int minGrowth = minCapacity - oldCapacity;
        int preferredGrowth = oldCapacity >> 1;
        int calcCapacity = Math.min(minGrowth, preferredGrowth) + oldCapacity;
        int newCapacity = Math.min(calcCapacity, Integer.MAX_VALUE);
        this.array = Arrays.copyOf(array, newCapacity);
        this.capacity = newCapacity;
    }

    /**
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("index overflow");
        }

        return array[index];
    }

    /**
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (this.array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(this.array[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * @param index
     */
    public void remove(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("index overflow");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    /**
     * @param o
     */
    public void remove(Object o) {
        int i = indexOf(o);
        remove(i);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyArrayList my = new MyArrayList();
        for (int i = 0; i < 100; i++) {
            my.add(i + "");
        }

        System.out.println(my.get(93));
        System.out.println(my.indexOf("93"));
        my.remove(3);
        System.out.println(my.indexOf("93"));
    }
}
