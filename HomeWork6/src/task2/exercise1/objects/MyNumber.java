package task2.exercise1.objects;

public class MyNumber implements Comparable<MyNumber> {

    private int value;

    public MyNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(MyNumber o) {
        if (value == o.value) {
            return 0;
        } else if (value < o.value) {
            return -1;
        } else
            return 1;
    }
}