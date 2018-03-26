package com.gah.simaho.controller.admin;

import com.gah.simaho.controller.Branch;
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
public class BranchControllerAdmin implements Initializable, ControlledScreen {

    @Autowired
    private ScreensController screensController;

    @FXML private TableView<Branch> tblBranch;
    @FXML private TableColumn<Branch, Integer> colId;
    @FXML private TableColumn<Branch, String> colName;
    @FXML private TableColumn<Branch, String> colAddress;
    @FXML private TableColumn<Branch, String> colTelephone;


    ObservableList<Branch> data = FXCollections.observableArrayList(
            new Branch(1,"Cabang","Jalan fghijkl","085657885235"),
            new Branch(2,"Cabang Kota Bandung Cabang Kota Bandung Cabang Kota Bandung","Jalan abcde","085602191388")

    );


    public void test(ActionEvent actionEvent) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        screensController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colId.setCellValueFactory(new PropertyValueFactory<Branch, Integer>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<Branch, String>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Branch, String>("Address"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<Branch, String>("Telephone"));
        tblBranch.setItems(data);
    }
}
