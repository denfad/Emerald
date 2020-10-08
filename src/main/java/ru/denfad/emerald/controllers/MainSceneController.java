package ru.denfad.emerald.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainSceneController {

    @FXML
    private Button mainButton;

    @FXML
    private void buttonClicked() {
        System.out.println("Button clicked!");
        mainButton.setText("Hi");
    }
}
