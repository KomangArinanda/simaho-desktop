package com.gah.simaho.controller;

import com.gah.simaho.controller.config.ControlledScreen;
import com.gah.simaho.controller.config.ScreenList;
import com.gah.simaho.controller.config.ScreensController;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController  implements Initializable, ControlledScreen {

    @Autowired
    private ScreensController screensController;

    @FXML private JFXTextField email;
    @FXML private JFXPasswordField password;


    public void login(ActionEvent actionEvent) {
        screensController.setScreen(ScreenList.screen1Id);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}
