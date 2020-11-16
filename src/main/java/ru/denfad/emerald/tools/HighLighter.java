package ru.denfad.emerald.tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.uielements.Component;

import java.util.List;

public class HighLighter implements Tool {

    private double startX, startY;
    private double endX, endY;
    private Rectangle highlightRect;

    @Override
    public void onMouseDragged(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        endX = event.getX();
        endY = event.getY();
        highlightRect.setHeight(endY - startY);
        highlightRect.setWidth(endX - startX);
        for (Component c : shapesDao.getShapes()) {
            if (isHighlight(c)) {
                shapes.add(c);
                c.select();
            }
        }

    }

    @Override
    public void onMousePressed(MouseEvent event, List<Component> shapes, Component component, ShapesDao shapesDao, Pane pane) {
        startX = event.getX();
        startY = event.getY();
        highlightRect = new Rectangle(startX, startY, 1, 1);
        highlightRect.setFill(null);
        highlightRect.setStroke(Color.BLUE);
        highlightRect.setStrokeType(StrokeType.OUTSIDE);
        highlightRect.setStrokeWidth(2);
        pane.getChildren().add(highlightRect);

    }

    @Override
    public void onMouseReleased(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        pane.getChildren().remove(highlightRect);
    }

    @Override
    public void clear(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {

    }

    private boolean isHighlight(Component c) {
        System.out.println(c.getCompCenterX() + " " + c.getCompCenterY() + " " + startX + " " + startY);
        if (c.getCompCenterX() > startX & c.getCompCenterX() < endX & c.getCompCenterY() > startY & c.getCompCenterY() < endY) {
            return true;
        }
        return false;
    }
}
