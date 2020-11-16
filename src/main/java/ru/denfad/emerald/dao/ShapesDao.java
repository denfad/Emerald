package ru.denfad.emerald.dao;

import javafx.scene.shape.Shape;
import ru.denfad.emerald.uielements.Component;

import java.util.ArrayList;
import java.util.List;

public class ShapesDao {
    private List<Component> shapes;

    public ShapesDao(List<Component> shapes) {
        this.shapes = shapes;
    }

    public ShapesDao() {
        shapes = new ArrayList<>();
    }

    public List<Component> getShapes() {
        return shapes;
    }

    public void setShapes(List<Component> shapes) {
        this.shapes = shapes;
    }

    public Component getShape(int index) {
        return shapes.get(index);
    }

    public void addShape(Component shape) {
        shapes.add(shape);
    }
}
