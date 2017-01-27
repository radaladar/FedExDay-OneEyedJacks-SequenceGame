/// Created by BB on 2017-01-27.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.controller;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.service.GameLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.ResourceBundle;

@NoArgsConstructor
public class BoardScreenController implements Initializable {

    GameLogic gameLogic;
    @FXML
    Label numberofplayers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void newGame(int players) {
        gameLogic = new GameLogic(players, "aaa");
        numberofplayers.setText("number of players: " + Integer.toString(gameLogic.getNumberOfTeam()));
    }
}
