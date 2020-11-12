package ru.denfad.emerald.uielements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

public class RectangleComponent extends Rectangle implements Component {

    private boolean isSelect = false;
    @Override
    public void drag(double x, double y) {
        super.setX(x);
        super.setY(y);
    }

    @Override
    public void translate(double dx, double dy) {
        super.setTranslateX(dx);
        super.setTranslateY(dy);
    }

    @Override
    public void resize(double width, double height) {
        super.setWidth(width);
        super.setHeight(height);
    }

    @Override
    public double getCenterX() {
        return getX()+ getWidth()/2;
    }

    @Override
    public double getCenterY() {
        return getY()+getHeight()/2;
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
