package task2.exercise1.sorters;

import java.util.Arrays;

public class SelectionSorter implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] array, Direction direction) {
        Comparable[] returnArray = Arrays.copyOf(array, array.length);
        if (direction.equals(Direction.ASK)) {
            return ask(returnArray);
        } else {
            return desk(returnArray);
        }
    }

    private Comparable[] ask(Comparable[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arrays.length; j++) {
                if ((arrays[j].compareTo(arrays[minIndex])) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comparable temp = arrays[i];
                arrays[i] = arrays[minIndex];
                arrays[minIndex] = temp;
            }
        }
        return arrays;
    }

    private Comparable[] desk(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if ((array[j].compareTo(array[minIndex])) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comparable temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}