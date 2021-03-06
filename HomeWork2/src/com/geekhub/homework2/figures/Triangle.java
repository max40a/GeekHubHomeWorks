package com.geekhub.homework2.figures;

import com.geekhub.homework2.interfaces.Shape;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle implements Shape {

    private double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /*
    * To calculate the area of a triangle with given sides, using Heron's formula.
    */
    @Override
    public double calculateArea() {
        double semiPerimeter = calculatePerimeter() / 2;
        return sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public static double calculateHypotenuse(double a, double b) {
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public static boolean validateTriangleExistence(Triangle t) {
        return !((t.sideA + t.sideB) < t.sideC || (t.sideA + t.sideC) < t.sideB || (t.sideB + t.sideC) < t.sideA);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}