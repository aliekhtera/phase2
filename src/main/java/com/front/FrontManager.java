package com.front;

import com.dataBase.DataBaseGetter;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontManager extends Application {
    public static void startProgram(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("");// todo title
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(SceneManager.getInstance().getNewLoginScene());
        stage.show();
        StageManager.getInstance().setMainStage(stage);

        /*  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    static void textFieldSetter(TextField textField, ControllerType controllerType) {
        String text = textField.getText();
        Boolean flag=null;
        if (text == null) {
            text = "";
        }
        int l=text.length();
        switch (controllerType) {
            case PASSWORD:
                flag= (l>7 && l<45);
                break;
            case NEW_USERNAME:
                flag=(l>0 && l<45 && DataBaseGetter.getInstance().getUser(text)==null );
                break;
            case OLD_USERNAME:
                flag=(l>0 && l<45 && DataBaseGetter.getInstance().getUser(text)!=null );
                break;
            case SECURITY_ANSWER:
                flag=(l>0 && l<45);
                break;
            case LAST_NAME:
                flag=(l>0 && l<45);
                break;
            case FIRST_NAME:
                flag=(l>0 && l<45);
                break;
        }
        if (flag == null) {
         return;
        }
        if(flag){
            textField.setStyle("-fx-text-box-border : #438d46 ; -fx-focus-color :#438d46;");
        }else{
            textField.setStyle("-fx-text-box-border : #B22222 ; -fx-focus-color :#B22222;");
        }
    }

}
