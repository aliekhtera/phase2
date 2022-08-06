package com.front;

import com.back.MethodReturns;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StageManager {

    static private StageManager instance = new StageManager();

    private StageManager() {
    }

    public static StageManager getInstance() {
        return instance;
    }

    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    void openNewStage(Scene scene, String title) {
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setResizable(false);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(mainStage);
        newStage.setScene(scene);
        newStage.showAndWait();
    }

    void showErrorDialog(String content) {
        // Alert alert=new Alert(Alert.AlertType.ERROR);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("ERROR!");
        ButtonType buttonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonType);
        dialog.setContentText(content);
        dialog.showAndWait();
      //  return null;
    }

    Scene showError(String content) {
        // Alert alert=new Alert(Alert.AlertType.ERROR);
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("ERROR!");
        ButtonType buttonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonType);
        dialog.setContentText(content);
        dialog.showAndWait();
        return null;
    }

    void showDoneDialog(){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Done!");
        ButtonType buttonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonType);
        dialog.setContentText("Done!");
        dialog.showAndWait();
    }

    boolean showDialog(MethodReturns input) {
        if (input==null){
            return false;
        }
        if(input.equals(MethodReturns.DONE)){
            showDoneDialog();
            return true;
        }
        String text = " ";
        switch (input) {

        }
        showErrorDialog(text);
        return false;
    }

    void changeScene(Scene scene) {
        try {
            mainStage.setScene(scene);
        } catch (Exception e) {
            showDialog(MethodReturns.UNKNOWN_FRONT_ERROR);
        }
    }

    void openNewStage(Scene scene, String title, Window window) {
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setResizable(false);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(window);
        newStage.setScene(scene);
        newStage.showAndWait();
    }

}
