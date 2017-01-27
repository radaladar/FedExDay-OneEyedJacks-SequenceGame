package com.sequencegame.oneeyedjacks.fedexday.greenfox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SequencegameApplication extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Welcome.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e -> Platform.exit());
	}
}
