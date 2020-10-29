package ru.denfad.emerald.dao;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapesDao {
    private List<Shape> shapes;

    public ShapesDao(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public ShapesDao() {
        shapes = new ArrayList<>();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Shape getShape(int index){
        return shapes.get(index);
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }
}
