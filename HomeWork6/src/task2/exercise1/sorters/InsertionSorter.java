package task2.exercise1.sorters;

import java.util.Arrays;

public class InsertionSorter implements ArraySorter {

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
        for (int i = 1; i < array.length; i++) {
            Comparable newValue = array[i];
            int j = i;
            while (j > 0 && (array[j - 1].compareTo(newValue)) > 1) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }
        return array;
    }

    private Comparable[] desk(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable newValue = array[i];
            int j = i;
            while (j > 0 && (array[j - 1].compareTo(newValue)) < 1) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }
        return array;
    }
}