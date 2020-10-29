package ru.denfad.emerald.controllers;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import ru.denfad.emerald.dao.ShapesDao;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    double startX;
    double startY;
    double deltaX, deltaY;
    int num=0;
    private ShapesDao shapes;
    private Shape selectedShape = new Rectangle();
    private boolean isShapeDragged = false, isShapeDragging = false;

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane pane;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        shapes = new ShapesDao();


        stackPane.setStyle(" -fx-background-color: #bfa000");

        pane.setStyle(" -fx-background-color: #fff8fb");
        pane.setOnMousePressed(event -> {
            if(!isShapeDragging) {
                selectedShape.setStroke(null);
                startX = event.getX();
                startY = event.getY();
                System.out.println(startX + " " + startY);

                Rectangle re = new Rectangle();
                re.setX(startX);
                re.setY(startY);
                re.setHeight(Math.abs(event.getY() - startY));
                re.setWidth(Math.abs(event.getX() - startX));
                pane.getChildren().add(re);

                for (Node n : shapes.getShapes()) {
                    System.out.println(n.toString());
                }
            }
        });

        pane.setOnMouseDragged(event -> {
            if(!isShapeDragging) {
                Rectangle re = new Rectangle();
                re.setX(startX);
                re.setY(startY);
                re.setHeight(Math.abs(event.getY() - startY));
                re.setWidth(Math.abs(event.getX() - startX));
                try {
                    pane.getChildren().remove(pane.getChildren().size() - 1);
                } catch (Exception e) {
                }
                pane.getChildren().add(re);
            }
        });




        pane.setOnMouseReleased(event ->{
            if(!isShapeDragging & isShapeDragged == false) {
                Rectangle re = new Rectangle();
                re.setX(startX);
                re.setY(startY);
                re.setHeight(Math.abs(event.getY() - startY));
                re.setWidth(Math.abs(event.getX() - startX));
                re.setId("num" + num);
                re.setOnMouseClicked(event1 -> {
                    selectShape(re);
                });
                re.setOnMousePressed(event1 -> {
                    deltaX = event1.getX() - re.getX();
                    deltaY = event1.getY() - re.getY();
                });
                re.setOnMouseDragged(event1 -> {
                    isShapeDragging = true;
                    selectShape(re);
                    re.setX(event1.getX()-deltaX);
                    re.setY(event1.getY()-deltaY);
                });
                re.setOnMouseReleased(event1 -> {
                    isShapeDragging = false;
                    isShapeDragged = true;
                });
                pane.getChildren().remove(pane.getChildren().size() - 1);
                if (re.getHeight() > 1 & re.getHeight() > 1) {
                    pane.getChildren().add(re);
                    shapes.addShape(re);
                    num++;
                }
            }
            else isShapeDragged = false;
        });


    }

    private void selectShape(Shape shape){
        selectedShape.setStroke(null);
        shape.setStroke(Color.RED);
        shape.setStrokeWidth(3);
        shape.setStrokeType(StrokeType.OUTSIDE);
        selectedShape = shape;
    }



}
