package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

class DynamicIntArray {

    private int[] array;

    DynamicIntArray(int arraySize) {
        this.array = new int[arraySize];
    }

    DynamicIntArray() {
        this.array = new int[0];
        }

    void add(int value){
        array = Arrays.copyOf(array, array.length +1);
        int size = array.length-1;
        array[size] = value;
    }
    void remove(int index) {
        int actualSize = array.length;

        if (index < 0 || index >= actualSize) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int[] newArray = new int[actualSize-1];
            int newArrayIndex = 0;

            for (int element : array) {

                if (element != index) {
                    newArray[newArrayIndex] = element;
                    newArrayIndex++;
                }
            }
            this.array = newArray;
            }
        }

    void insert(int index, int value) {
        if (index > array.length - 1) {
            add(value);
        } else {

            int[] newArray = new int[array.length + 1];
            newArray[index] = value;

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, array.length - index);
            this.array = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int resultValue : array) {
            result.append(" ");
            result.append(resultValue);
        }
        return result.toString();
    }
}
