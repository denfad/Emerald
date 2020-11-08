package ru.denfad.emerald.tools;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ru.denfad.emerald.dao.ShapesDao;

import java.util.List;

public interface Tool {
    void onMouseDragged(MouseEvent event, List<Rectangle> shapes, ShapesDao shapesDao);
    void onMousePressed(MouseEvent event,List<Rectangle> shapes, ShapesDao shapesDao);
    void onMouseReleased(MouseEvent event,List<Rectangle> shapes, ShapesDao shapesDao);
}
