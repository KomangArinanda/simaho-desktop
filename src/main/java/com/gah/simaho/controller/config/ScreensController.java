package com.gah.simaho.controller.config;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class ScreensController extends StackPane{

    public HashMap<String, Node> screens = new HashMap<>();

    public ScreensController(){
        super();
    }

    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }

    public Node getScreen(String name){
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = loader.load();
            ControlledScreen controlledScreen = ((ControlledScreen) loader.getController());
            controlledScreen.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        }catch (Exception EX){
            System.out.println("loadScreen "+EX.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name){
        if(screens.get(name) != null){
            final DoubleProperty opacity = opacityProperty();

            if(!getChildren().isEmpty()){
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(100), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                        fade.play();
            }else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(1500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }

    public boolean unloadScreen(String name){
        if(screens.remove(name) == null){
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }

    public ScreensController initAllScreen(){

        ScreensController mainContainer = new ScreensController();



        mainContainer.loadScreen(ScreenList.screen1Id, ScreenList.screenFile1);
        mainContainer.loadScreen(ScreenList.mainScreenId, ScreenList.mainScreenFile);

        mainContainer.setScreen(ScreenList.mainScreenId);
        return mainContainer;
    }
}
