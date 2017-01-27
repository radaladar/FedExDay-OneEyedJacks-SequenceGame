package com.sequencegame.oneeyedjacks.fedexday.greenfox.controller;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.SequencegameApplication;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Created by ${SzilviaB} on 2017. 01. 26..
 */
@Component
public class WelcomeScreenController {

    private SequencegameApplication main;

    @FXML
    public void getBoardSceen() throws IOException {
            main.showMainScreen();
    }

}


