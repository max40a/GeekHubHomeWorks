package task2.exercise1.sorters;

import java.util.Arrays;

public class SelectionSorter implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] array, Direction direction) {
        int directionFlag = 1;
        Comparable[] returnArray = Arrays.copyOf(array, array.length);

        if (direction.equals(Direction.DESC)) {
            directionFlag = -1;
        }

        for (int i = 0; i < returnArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < returnArray.length; j++) {
                if (((returnArray[j].compareTo(returnArray[minIndex])) * directionFlag) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comparable temp = returnArray[i];
                returnArray[i] = returnArray[minIndex];
                returnArray[minIndex] = temp;
            }
        }
        return returnArray;
    }
}