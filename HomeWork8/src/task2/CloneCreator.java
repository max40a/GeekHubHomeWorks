package task2;

import task1.test.Cat;
import task1.test.Paw;

import java.awt.*;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class CloneCreator {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Cat myCat = new Cat();

        myCat.setColor(Color.GREEN);
        myCat.setAge(2);
        myCat.setName("My cat");

        java.util.List<Integer> whiskers = myCat.getWhiskers();
        whiskers.add(1);
        whiskers.add(2);
        whiskers.add(3);
        whiskers.add(4);

        myCat.setBirthDay(LocalDate.now());

        myCat.getPaws().put("front-left", new Paw(12, Color.BLUE));
        myCat.getPaws().put("front-right", new Paw(14, Color.RED));
        myCat.getPaws().put("back-left", new Paw(12, Color.YELLOW));
        myCat.getPaws().put("back-right", new Paw(14, Color.GREEN));

        BeanRepresenter.showBean(myCat);
        System.out.println();
        Cat clone = (Cat) cloneCreator(myCat);
        BeanRepresenter.showBean(clone);
        System.out.println();
        BeanComparator.compareBean(myCat, clone);
    }

    private static Object cloneCreator(Object o) throws IllegalAccessException, InstantiationException {
        Class clazz = o.getClass();
        Object instance = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);

        for(Field field: fields){
            field.set(instance, field.get(o));
        }

        return instance;
    }
}