package task1.test;

import task1.json.JsonSerializer;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();

        cat.setColor(Color.GRAY);
        cat.setAge(4);
        cat.setName("Tom");

        List<Integer> whiskers = cat.getWhiskers();
        whiskers.add(1);
        whiskers.add(2);
        whiskers.add(3);
        whiskers.add(4);
        whiskers.add(5);
        whiskers.add(6);

        cat.setBirthDay(LocalDate.now());

        cat.getPaws().put("front-left", new Paw(23, Color.GRAY));
        cat.getPaws().put("front-right", new Paw(24, Color.WHITE));
        cat.getPaws().put("back-left", new Paw(23, Color.BLACK));
        cat.getPaws().put("back-right", new Paw(24, Color.GRAY));

        System.out.println(JsonSerializer.serialize(cat));
    }
}