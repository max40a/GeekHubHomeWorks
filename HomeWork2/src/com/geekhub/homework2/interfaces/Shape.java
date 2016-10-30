package com.geekhub.homework2.interfaces;

public interface Shape {
    double calculateArea();
    double calculatePerimeter();

    static void showResults(Shape shape) {
        System.out.printf("%s : area = %.3f sq.u, perimeter = %.3f u.\n", shape, shape.calculateArea(), shape.calculatePerimeter());
    }
}