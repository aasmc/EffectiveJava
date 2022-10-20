package ru.aasmc.effectivejava.chapter_04.item_23;

/**
 * Example of a tagged class. It is verbose, error-prone and inefficient.
 */
public class Figure {
    enum Shape {RECTANGLE, CIRCLE};

    // Tag field - the shape of this figure
    final Shape shape;

    // these fields are used only if shape is rectangle
    double length;
    double width;

    // this field is used only if shape is Circle
    double radius;

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE -> {
                return length * width;
            }
            case CIRCLE -> {
                return Math.PI * (radius * radius);
            }
            default -> {
                throw new AssertionError(shape);
            }
        }
    }
}
