package com.sequencegame.oneeyedjacks.fedexday.greenfox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SequencegameApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private BorderPane welcomeNode;
    private BorderPane boardNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(welcomeNode));
		stage.show();
		stage.setOnCloseRequest(e -> Platform.exit());
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(SequencegameApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Welcome.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		welcomeNode = fxmlLoader.load();
	}


	public void showMainScreen() throws IOException {
		FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));
		mainScreenLoader.setControllerFactory(springContext::getBean);
		boardNode = mainScreenLoader.load();
	}
}
