package com.sequencegame.oneeyedjacks.fedexday.greenfox.controller;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.SequencegameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.SequenceInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;


/**
 * Created by ${SzilviaB} on 2017. 01. 26..
 */
public class WelcomeScreenController implements Initializable {

    @FXML
    public Button buttonplayer2;

    @FXML
    public void handleButtonClick(ActionEvent event) throws IOException {
        System.out.println("click!");
        Stage board_stage = new Stage();
        FXMLLoader loader = new FXMLLoader(SequencegameApplication.class.getResource("/fxml/Board.fxml"));
        Parent board = loader.load();
        BoardScreenController boardScreenController = loader.getController();
        boardScreenController.newGame(2);
        Scene boardscene = new Scene(board);
        board_stage.setScene(boardscene);
        board_stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
