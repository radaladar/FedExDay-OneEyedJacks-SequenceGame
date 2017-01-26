package com.sequencegame.oneeyedjacks.fedexday.greenfox.controller;

import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ${SzilviaB} on 2017. 01. 26..
 */
@Component
public class TabPaneManager {
    private final ConsoleTabController consoleTabController;
    private final LoggerTabController loggerTabController;

    @Autowired
    public TabPaneManager(ConsoleTabController consoleTabController, LoggerTabController loggerTabController) {
        this.consoleTabController = consoleTabController;
        this.loggerTabController = loggerTabController;
    }

    public TextArea getVisualLog() {
        return loggerTabController.getLoggerTxtArea();
    }
}
