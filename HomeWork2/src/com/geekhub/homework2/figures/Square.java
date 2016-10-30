package com.geekhub.homework2.figures;

import com.geekhub.homework2.interfaces.Shape;

import static java.lang.Math.pow;

public class Square implements Shape {

    protected double sideSquare;
    private Shape[] shapes = new Shape[2];

    public Square(double sideSquare) {
        this.sideSquare = sideSquare;
        for(int i = 0; i < shapes.length; i++) {
            shapes[i] = new Triangle(this.sideSquare, this.sideSquare, Triangle.calculateHypotenuse(this.sideSquare, this.sideSquare));
        }
    }

    @Override
    public double calculateArea() {
        return pow(sideSquare, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideSquare;
    }

    @Override
    public String toString() {
        for (Shape s: shapes) {
            Shape.showResults(s);
        }
        return "Square";
    }
}