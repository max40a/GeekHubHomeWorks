package task2.exercise1.sorters;

import java.util.Arrays;

public class BubbleSorter implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] array, Direction direction) {
        int directionFlag = 1;
        Comparable[] returnArray = Arrays.copyOf(array, array.length);

        if (direction.equals(Direction.DESC)) {
            directionFlag = -1;
        }

        for (int i = returnArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (((returnArray[j].compareTo(returnArray[j + 1])) * directionFlag) > 0) {
                    Comparable temp = returnArray[j];
                    returnArray[j] = returnArray[j + 1];
                    returnArray[j + 1] = temp;
                }
            }
        }
        return returnArray;
    }
}