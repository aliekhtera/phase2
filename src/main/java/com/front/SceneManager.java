package com.front;

import com.back.messages.Message;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneManager {
    private static SceneManager instance = new SceneManager();

    static SceneManager getInstance() {
        return instance;
    }

    private SceneManager() {
    }

    Scene getNewLoginScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnLogin.fxml"));
            return new Scene(fxmlLoader.load());
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }


    Scene getNewPassRecoveryScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnPassRecovery.fxml"));
            return new Scene(fxmlLoader.load());
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewMainScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnMain.fxml"));
            return new Scene(fxmlLoader.load());
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewSettingsScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnSettings.fxml"));
            return new Scene(fxmlLoader.load());
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewNewMessageScene(Message main, Message rep, boolean isForwarded) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnNewMessage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((ScnNewMessage)fxmlLoader.getController()).setMessage(main,rep,isForwarded);
            return scene;
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewGroupSettingScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnGroupSetting.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewGroupScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnGroup.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewMembersScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnMembers.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewBanAndRemoveScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnBanAndRemove.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }


}
