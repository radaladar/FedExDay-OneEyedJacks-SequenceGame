package com.sequencegame.oneeyedjacks.fedexday.greenfox;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SequencegameApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
//		springContext = SpringApplication.run(SequencegameApplication.class);
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
//				///ide jön a resources mappa;
//		));
//		fxmlLoader.setControllerFactory(springContext::getBean);
//		rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

}
