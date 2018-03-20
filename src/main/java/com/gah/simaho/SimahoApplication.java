package com.gah.simaho;

import com.gah.simaho.controller.config.ScreensController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimahoApplication extends Application{

	private ConfigurableApplicationContext springContext;
	private Group root = new Group();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(SimahoApplication.class);
		ScreensController mainContainer = new ScreensController();
		root.getChildren().addAll(mainContainer.initAllScreen());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
