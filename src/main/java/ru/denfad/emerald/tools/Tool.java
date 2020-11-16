package ru.denfad.emerald.tools;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.uielements.Component;

import java.util.List;

public interface Tool {
    void onMouseDragged(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane);

    void onMousePressed(MouseEvent event, List<Component> shapes, Component component, ShapesDao shapesDao, Pane pane);

    void onMouseReleased(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane);

    void clear(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane);
}
