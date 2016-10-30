package com.geekhub.homework2;

import com.geekhub.homework2.enumerations.ShapeType;
import com.geekhub.homework2.figures.*;
import com.geekhub.homework2.interfaces.Shape;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String shape;

        System.out.print("Please select the shape from a predefined list (Circle, Rectangle, Square, Triangle) : ");
        do {
            shape = scanner.next();
        } while (!validateInput(shape));

        switch (ShapeType.valueOf(shape.toUpperCase())) {
            case CIRCLE:
                inputAndShowCircleParameter();
                break;
            case RECTANGLE:
                inputAndShowRectangleParameters();
                break;
            case SQUARE:
                inputAndShowSquareParameter();
                break;
            case TRIANGLE:
                inputAndShowTriangleParameters();
                break;
        }
    }

    private static boolean validateInput(String s) {
        switch (s) {
            case "Circle":
            case "Square":
            case "Rectangle":
            case "Triangle":
                return true;
        }
        System.out.print("Please, enter the correct name of the figure : ");
        return false;
    }

    private static void inputAndShowCircleParameter() {
        System.out.print("Enter the radius of the circle : ");
        double radius;
        do {
            radius = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(radius));
        Shape.showResults(new Circle(radius));
    }

    private static void inputAndShowSquareParameter() {
        System.out.print("Enter the length side of the square : ");
        double side;
        do {
            side = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(side));
        Shape.showResults(new Square(side));
    }

    private static void inputAndShowRectangleParameters() {
        System.out.println("Enter the sides of the rectangle : ");
        System.out.print("a = ");
        double a, b;
        do {
            a = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(a));
        System.out.print("b = ");
        do {
            b = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(b));
        Shape.showResults(new Rectangle(a, b));
    }

    private static void inputAndShowTriangleParameters() {
        System.out.println("Enter the sides of triangle : ");
        double a, b, c;
        System.out.print("a = ");
        do {
            a = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(a));
        System.out.print("b = ");
        do {
            b = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(b));
        System.out.print("с = ");
        do {
            c = scanner.nextDouble();
        } while (!inputPositiveNumberValidate(c));
        Triangle triangle = new Triangle(a, b, c);
        if (Triangle.validateTriangleExistence(triangle)) {
            Shape.showResults(triangle);
        } else {
            System.out.println("Triangle with such given party can not exist!!!");
        }
    }

    private static boolean inputPositiveNumberValidate(double a) {
        if (a < 0) {
            System.out.print("Enter the number that is greater than zero : ");
            return false;
        }
        return true;
    }
}