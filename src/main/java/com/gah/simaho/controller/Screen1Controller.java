package com.gah.simaho.controller;

import com.gah.simaho.controller.config.ControlledScreen;
import com.gah.simaho.controller.config.ScreensController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class Screen1Controller implements Initializable, ControlledScreen {

    @Autowired
    private ScreensController screensController;

    @FXML private TableView<Branch> tblPengguna;
    @FXML private TableColumn<Branch, String> kolNama;
    @FXML private TableColumn<Branch, String> kolEmail;


    ObservableList<Branch> data = FXCollections.observableArrayList(
//            new Branch("Komang","arinanda.mail@gmail.com"),
//            new Branch("Egik","egik.mail@gmail.com"),
//            new Branch("marpaung","marpaung.mail@gmail.com"),
//            new Branch("manulang","manulang.mail@gmail.com"),
//            new Branch("siregar","siregar.mail@gmail.com"),
//            new Branch("hutabarat","hutabarat.mail@gmail.com"),
//            new Branch("Egik","egik.mail@gmail.com"),
//            new Branch("marpaung","marpaung.mail@gmail.com"),
//            new Branch("manulang","manulang.mail@gmail.com"),
//            new Branch("siregar","siregar.mail@gmail.com"),
//            new Branch("hutabarat","hutabarat.mail@gmail.com"),
//            new Branch("Egik","egik.mail@gmail.com"),
//            new Branch("marpaung","marpaung.mail@gmail.com"),
//            new Branch("manulang","manulang.mail@gmail.com"),
//            new Branch("siregar","siregar.mail@gmail.com"),
//            new Branch("hutabarat","hutabarat.mail@gmail.com"),
//            new Branch("Egik","egik.mail@gmail.com"),
//            new Branch("marpaung","marpaung.mail@gmail.com"),
//            new Branch("manulang","manulang.mail@gmail.com"),
//            new Branch("siregar","siregar.mail@gmail.com"),
//            new Branch("hutabarat","hutabarat.mail@gmail.com"),
//            new Branch("Egik","egik.mail@gmail.com"),
//            new Branch("marpaung","marpaung.mail@gmail.com"),
//            new Branch("manulang","manulang.mail@gmail.com"),
//            new Branch("siregar","siregar.mail@gmail.com"),
//            new Branch("hutabarat","hutabarat.mail@gmail.com")

    );


    public void test(ActionEvent actionEvent) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        kolNama.setCellValueFactory(new PropertyValueFactory<Branch, String>("Nama"));
        kolEmail.setCellValueFactory(new PropertyValueFactory<Branch, String>("Email"));
        tblPengguna.setItems(data);
    }
}
