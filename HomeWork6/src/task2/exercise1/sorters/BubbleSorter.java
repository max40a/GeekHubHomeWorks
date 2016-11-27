package task2.exercise1.sorters;

import java.util.Arrays;

public class BubbleSorter implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] array, Direction direction) {
        Comparable[] returnArray = Arrays.copyOf(array, array.length);
        if (direction.equals(Direction.ASK)) {
            return ask(returnArray);
        } else {
            return desk(returnArray);
        }
    }

    private Comparable[] ask(Comparable[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((array[j].compareTo(array[j + 1])) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private Comparable[] desk(Comparable[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((array[j].compareTo(array[j + 1])) < 0) {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}