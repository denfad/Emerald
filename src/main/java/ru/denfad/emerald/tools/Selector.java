package ru.denfad.emerald.tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.uielements.Component;

import java.util.List;

public class Selector implements Tool {

    double lastX, lastY;
    @Override
    public void onMouseDragged(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        if(shapes.isEmpty()){
            //TODO сделать выделение

        }
        else{
            for(Component selectedShape:shapes){
              selectedShape.translate(event.getX()- lastX, event.getY()-lastY);
            }
        }
    }

    @Override
    public void onMousePressed(MouseEvent event, List<Component> shapes, Component component, ShapesDao shapesDao, Pane pane) {
        lastX = event.getX();
        lastY = event.getY();
        if(event.getPickResult().getIntersectedNode() instanceof Shape){
            Shape shape = (Shape) event.getPickResult().getIntersectedNode();
            if(((Component) shape).isSelected()){
                ((Component) shape).unSelect();
                shapes.remove(shape);
            }
            else {
                shapes.add((Component) shape);
                ((Component) shape).select();
            }
        }
        else clear(event,shapes,shapesDao, pane);
    }

    @Override
    public void onMouseReleased(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
    }

    @Override
    public void clear(MouseEvent event, List<Component> shapes, ShapesDao shapesDao, Pane pane) {
        for(Component selectedShape:shapes){
            selectedShape.unSelect();
        }
        shapes.clear();
    }
}
