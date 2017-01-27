package com.sequencegame.oneeyedjacks.fedexday.greenfox.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));
        Parent board = fxmlLoader.load();
        Scene boardscene = new Scene(board);
        Stage board_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        board_stage.hide();
        board_stage.setScene(boardscene);
        board_stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
