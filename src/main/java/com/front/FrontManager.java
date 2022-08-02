package com.front;

import com.dataBase.DataBaseGetter;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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
        Boolean flag = null;
        if (text == null) {
            text = "";
        }
        int l = text.length();
        switch (controllerType) {
            case PASSWORD:
                flag = (l > 7 && l < 45);
                break;
            case NEW_USERNAME:
                flag = (l > 0 && l < 45 && DataBaseGetter.getInstance().getUser(text) == null);
                break;
            case OLD_USERNAME:
                flag = (l > 0 && l < 45 && DataBaseGetter.getInstance().getUser(text) != null);
                break;
            case SECURITY_ANSWER:
                flag = (l > 0 && l < 45);
                break;
            case LAST_NAME:
                flag = (l > 0 && l < 45);
                break;
            case FIRST_NAME:
                flag = (l > 0 && l < 45);
                break;
        }
        if (flag == null) {
            return;
        }
        if (flag) {
            textField.setStyle("-fx-text-box-border : #438d46 ; -fx-focus-color :#438d46;");
        } else {
            textField.setStyle("-fx-text-box-border : #B22222 ; -fx-focus-color :#B22222;");
        }
    }

    static String openImage(ImageView imageView) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Image Files",
                "*.png", "*.jpg", "*.jpeg");
        fileChooser.setSelectedExtensionFilter(extensionFilter);
        File result = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        return fileToImage(imageView,result);
    }

    public static String fileToImage(ImageView imageView,File file){
        if(file==null){
            return null;
        }
        Image oldImage = new Image(file.toURI().toString());
        Image newImage=cropImage(oldImage);
        imageView.setImage(newImage);
        return file.getAbsolutePath();
    }

    public static Image cropImage(Image oldImage){
        Image newImage;
        if (oldImage.getWidth() != oldImage.getHeight()) {
            int x, y, a;
            if (oldImage.getWidth() > oldImage.getHeight()) {
                y = 0;
                a = (int) oldImage.getHeight();
                x = (int) ((oldImage.getWidth() - oldImage.getHeight()) / 2);
            } else {
                x = 0;
                a = (int) oldImage.getWidth();
                y = (int) (oldImage.getHeight() - oldImage.getWidth()) / 2;
            }
            newImage = new WritableImage(oldImage.getPixelReader(), x, y, a, a);
        } else {
            newImage = oldImage;
        }
        return newImage;
    }


}
