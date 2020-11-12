package ru.denfad.emerald.uielements;

import javafx.scene.shape.Shape;

import java.awt.*;

public interface Component  {
    void drag(double x, double y);
    void translate(double dx, double dy);
    void resize(double width, double height);
    double getCenterX();
    double getCenterY();
    double getWidth();
    double getHeight();
    Shape getShape();
    void select();
    void unSelect();
    boolean isSelected();
}
