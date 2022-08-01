package com;

import com.dataBase.DataBaseManager;
import com.front.FrontManager;
import com.front.SceneManager;
import com.front.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main  {
    public static void main(String[] args) throws SQLException {
        DataBaseManager.getInstance().initialize();
        //launch(args);
        FrontManager.startProgram(args);
    }
}

