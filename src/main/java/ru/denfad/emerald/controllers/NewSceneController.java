package ru.denfad.emerald.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import ru.denfad.emerald.dao.ShapesDao;
import ru.denfad.emerald.tools.Drawer;
import ru.denfad.emerald.tools.HighLighter;
import ru.denfad.emerald.tools.Selector;
import ru.denfad.emerald.tools.Tool;
import ru.denfad.emerald.uielements.Component;
import ru.denfad.emerald.uielements.RectangleComponent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewSceneController implements Initializable {
    private ShapesDao shapes;
    private List<Component> selectedShapes = new ArrayList<>();
    private Tool tool = new Selector();


    @FXML
    private StackPane stackPane;

    @FXML
    private Pane pane;

    @FXML
    private Button draw;

    @FXML
    private Button select;

    @FXML
    private Button highlight;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        shapes = new ShapesDao();

        draw.setOnMouseClicked(event -> {
            tool.clear(event, selectedShapes, shapes, pane);
            tool = new Drawer();
        });

        select.setOnMouseClicked(event -> {
            tool.clear(event, selectedShapes, shapes, pane);
            tool = new Selector();
        });

        highlight.setOnMouseClicked(event -> {
            tool.clear(event, selectedShapes, shapes, pane);
            tool = new HighLighter();
        });

        stackPane.setStyle(" -fx-background-color: #bfa000");

        pane.setStyle(" -fx-background-color: #fff8fb");
        pane.setOnMousePressed(event -> {
            double startX = event.getX();
            double startY = event.getY();

            RectangleComponent re = new RectangleComponent();
            re.setX(startX);
            re.setY(startY);
            re.setHeight(Math.abs(event.getY() - startY));
            re.setWidth(Math.abs(event.getX() - startX));
            tool.onMousePressed(event, selectedShapes, re, shapes, pane);
        });

        pane.setOnMouseDragged(event -> {
            tool.onMouseDragged(event, selectedShapes, shapes, pane);
        });


        pane.setOnMouseReleased(event -> {
            tool.onMouseReleased(event, selectedShapes, shapes, pane);
        });


    }


}
