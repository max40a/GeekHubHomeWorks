package com.geekhub.homework2.figures;

import com.geekhub.homework2.interfaces.Shape;


public class Rectangle extends Square {

    private double sideRectangle;
    private Shape[] shapes = new Shape[2];

    public Rectangle(double side, double sideB) {
        super(side);
        this.sideRectangle = sideB;
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new Triangle(this.sideSquare, this.sideRectangle, Triangle.calculateHypotenuse(this.sideRectangle, this.sideSquare));
        }
    }

    @Override
    public double calculateArea() {
        return sideSquare * sideRectangle;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideSquare + sideRectangle);
    }

    @Override
    public String toString() {
        for(Shape s: shapes) {
            Shape.showResults(s);
        }
        return "Rectangle";
    }
}