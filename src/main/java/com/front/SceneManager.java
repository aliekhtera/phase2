package com.front;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneManager {
    private static SceneManager instance=new SceneManager();
   static SceneManager getInstance(){
        return instance;
    }
    private SceneManager(){}

     Scene getNewLoginScene(){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnLogin.fxml"));
           return new Scene(fxmlLoader.load());
       }catch (Exception e){
           StageManager.getInstance().showErrorDialog("Unknown Error!");
           return getNewLoginScene();
       }
    }


    Scene getNewPassRecoveryScene(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnPassRecovery.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }
    Scene getNewMainScene(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnMain.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }
    Scene getNewSettingsScene(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnSettings.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }
}
