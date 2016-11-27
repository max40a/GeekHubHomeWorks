package task2.exercise1.sorters;

import java.util.Arrays;

public class InsertionSorter implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] array, Direction direction) {
        int directionFlag = -1;
        Comparable[] returnArray = Arrays.copyOf(array, array.length);

        if (direction.equals(Direction.DESC)) {
            directionFlag = 1;
        }

        for (int i = 1; i < array.length; i++) {
            Comparable newValue = array[i];
            int j = i;
            while (j > 0 && ((array[j - 1].compareTo(newValue)) * directionFlag) < 1) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }
        return array;
    }
}