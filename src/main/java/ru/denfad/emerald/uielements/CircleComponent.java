package ru.denfad.emerald.uielements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

public class CircleComponent extends Circle implements Component {
    private boolean isSelect = false;
    private double x,y;
    @Override
    public void drag(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
        this.x = x;
         this.y = y;
    }

    @Override
    public void resize(double width, double height) {
        setRadius(width/2);
        setLayoutX(x + width/2);
         setLayoutY(y + width/2);
    }

    @Override
    public double getCompCenterX() {
        return getLayoutX();
    }

    @Override
    public double getCompCenterY() {
        return getLayoutY();
    }

    @Override
    public void translate(double dx, double dy) {
       super.setTranslateX(dx);
       super.setTranslateY(dy);
    }

    @Override
    public double getWidth() {
        return getRadius();
    }

    @Override
    public double getHeight() {
        return getRadius();
    }

    @Override
    public Shape getShape() {
        return this;
    }

    @Override
    public void select() {
        isSelect = true;
        setStroke(Color.RED);
        setStrokeType(StrokeType.OUTSIDE);
        setStrokeWidth(3);
    }

    @Override
    public void unSelect() {
        this.isSelect = false;
        setStroke(null);
    }

    @Override
    public boolean isSelected() {
        return isSelect;
    }


}
