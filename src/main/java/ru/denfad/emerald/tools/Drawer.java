package ru.denfad.emerald.tools;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ru.denfad.emerald.dao.ShapesDao;

import java.util.List;

public class Drawer implements Tool {
    double startX;
    double startY;
    @Override
    public void onMouseDragged(MouseEvent event, List<Rectangle> shapes, ShapesDao shapesDao) {
        for(Rectangle selectedShape:shapes) {
            selectedShape.setHeight(Math.abs(event.getY()- startY));
            selectedShape.setWidth(Math.abs(event.getX() - startX));
        }
    }

    @Override
    public void onMousePressed(MouseEvent event, List<Rectangle> shapes, ShapesDao shapesDao) {
        startY = event.getY();
        startX = event.getX();
    }

    @Override
    public void onMouseReleased(MouseEvent event, List<Rectangle> shapes, ShapesDao shapesDao) {
        for(Rectangle selectedShape: shapes) {
            if (selectedShape.getHeight() > 1 & selectedShape.getWidth() > 1) {
                shapesDao.addShape(selectedShape);
            }
            shapes.clear();
        }
    }
}
