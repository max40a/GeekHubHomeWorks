package task2;

import task1.json.Ignore;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

class Car {
    String model;
    @Ignore int yearOfManufacture;
    int speed;

    public Car(String model, int yearOfManufacture, int speed) {
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.speed = speed;
    }
}


public class BeanRepresenter {
    public static void main(String[] args) throws IllegalAccessException {
        Car bmw = new Car("Bmw", 2012, 250);
        Car volvo = new Car("Volvo", 2007, 180);

        showBean(bmw);
        System.out.println();
        showBean(volvo);
    }

    public static void showBean(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field f : fields) {
            if(f.isAnnotationPresent(Ignore.class)) {
                continue;
            }
            System.out.println(f.getName() + " : " + f.get(o));
        }
    }
}