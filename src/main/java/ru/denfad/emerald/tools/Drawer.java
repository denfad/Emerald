package ru.denfad.emerald.tools;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.uielements.Component;

import java.util.List;

public class Drawer implements Tool {
    double startX;
    double startY;

    @Override
    public void onMouseDragged(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        for (Component selectedShape : shapes) {
            selectedShape.resize(Math.abs(event.getX() - startX), Math.abs(event.getY() - startY));
        }
    }

    @Override
    public void onMousePressed(MouseEvent event, List<Component> shapes, Component component, ShapesDao shapesDao, Pane pane) {
        for (Component c : shapes) {
            c.unSelect();
        }
        shapes.clear();
        startY = event.getY();
        startX = event.getX();
        shapes.add(component);
        pane.getChildren().add(component.getShape());
    }

    @Override
    public void onMouseReleased(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        for (Component selectedShape : shapes) {
            if (selectedShape.getWidth() > 1 & selectedShape.getHeight() > 1) {
                shapesDao.addShape(selectedShape);
            }
            shapes.clear();
        }
    }

    @Override
    public void clear(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {

    }
}
