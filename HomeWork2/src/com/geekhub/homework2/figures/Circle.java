package com.geekhub.homework2.figures;

import com.geekhub.homework2.interfaces.Shape;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 2 * PI * pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}