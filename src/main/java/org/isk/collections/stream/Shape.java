package org.isk.collections.stream;

import java.awt.*;

/**
 * @author Yohan Beschi
 */
public class Shape {
    private Color color;

    private ShapeNameEnum shapeName;

    private int weight;

    public Shape(Color color, ShapeNameEnum shapeName, int weight) {
        this.color = color;
        this.shapeName = shapeName;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ShapeNameEnum getShapeName() {
        return shapeName;
    }

    public void setShapeName(ShapeNameEnum shapeName) {
        this.shapeName = shapeName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public enum ShapeNameEnum {
        CIRCLE, SQUARE, RECTANGLE, TRIANGLE;
    }
}
