package task2;

import task2.annotations.Ignore;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

class Person {

    String firstName;
    String secondName;
    int age;
    @Ignore int height;

    public Person(String name, String secondName, int age, int height) {
        this.firstName = name;
        this.secondName = secondName;
        this.age = age;
        this.height = height;
    }
}


public class BeanComparator {
    public static void main(String[] args) throws IllegalAccessException {
        Person jon = new Person("Jon", "Soroka", 27, 186);
        Person joe = new Person("Joe", "Soroka", 27, 175);

        Car car = new Car("bmw", 2015, 250);

        compareBean(jon, joe);
        compareBean(joe, car);
    }

    public static void compareBean(Object o1, Object o2) throws IllegalAccessException {
        if (o1.getClass() != o2.getClass()) {
            System.out.println("This classes not compared!!!");
            return;
        }

        Field[] fieldsOfObject = getFields(o1);

        StringBuilder tableOfCompare = new StringBuilder();
        for (int i = 0; i < fieldsOfObject.length; i++) {
            if (fieldsOfObject[i].isAnnotationPresent(Ignore.class)) {
                continue;
            } else {
                boolean resultOfCompareCurrentField = compareFields(fieldsOfObject[i], o1, o2);

                tableOfCompare.append(fieldsOfObject[i].getName());
                tableOfCompare.append(" - ");
                tableOfCompare.append(fieldsOfObject[i].get(o1));
                tableOfCompare.append(" :: ");
                tableOfCompare.append(fieldsOfObject[i].getName());
                tableOfCompare.append(" - ");
                tableOfCompare.append(fieldsOfObject[i].get(o2));
                tableOfCompare.append(" is ");
                tableOfCompare.append(resultOfCompareCurrentField);
                tableOfCompare.append("\n");
            }
        }
        printResult(tableOfCompare);
    }

    private static Field[] getFields(Object o) {
        Class clazz = o.getClass();
        Field[] fieldsArray = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fieldsArray, true);
        return fieldsArray;
    }

    private static boolean compareFields(Field f, Object o1, Object o2) throws IllegalAccessException {
        return f.get(o1).equals(f.get(o2));
    }

    private static void printResult(StringBuilder sb) {
        System.out.println(sb.toString());
    }
}