package ru.denfad.emerald.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.tools.Drawer;
import ru.denfad.emerald.tools.Tool;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewSceneController implements Initializable {
    private ShapesDao shapes;
    private List<Rectangle> selectedShapes = new ArrayList<>();
    private Tool tool;


    @FXML
    private StackPane stackPane;

    @FXML
    private Pane pane;

    @FXML
    private Button draw;

    @FXML
    private Button select;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tool = new Drawer();
        shapes = new ShapesDao();

        stackPane.setStyle(" -fx-background-color: #bfa000");

        pane.setStyle(" -fx-background-color: #fff8fb");
        pane.setOnMousePressed(event -> {
                double startX = event.getX();
                double startY = event.getY();

                Rectangle re = new Rectangle();
                re.setX(startX);
                re.setY(startY);
                re.setHeight(Math.abs(event.getY() - startY));
                re.setWidth(Math.abs(event.getX() - startX));
                pane.getChildren().add(re);
                selectedShapes.add(re);
                tool.onMousePressed(event,selectedShapes,shapes);
        });

        pane.setOnMouseDragged(event -> {
           tool.onMouseDragged(event, selectedShapes,shapes);
        });




        pane.setOnMouseReleased(event ->{
            tool.onMouseReleased(event,selectedShapes,shapes);
        });


    }

    private void selectShape(Shape shape){
        for(Rectangle selectedShape:selectedShapes) selectedShape.setStroke(null);
        shape.setStroke(Color.RED);
        shape.setStrokeWidth(3);
        shape.setStrokeType(StrokeType.OUTSIDE);
       // selectedShape = shape;
    }




}
