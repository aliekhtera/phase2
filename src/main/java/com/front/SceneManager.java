package com.front;

import com.back.messages.Message;
import com.back.messengers.Group;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.sql.Blob;

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


    Scene getNewFileShowScene(Blob blob,String fileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnFileShow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((ScnFileShow) fxmlLoader.getController()).init(blob, fileName);
            return scene;
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewNewGroupScene(Group group) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnGroupSetting.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((ScnGroupSetting)fxmlLoader.getController()).setGroup(group);
            return scene;
        } catch (Exception e) {
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }


    Scene getNewSearchScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnSearch.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewSearchGroupScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnSearchGroup.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

    Scene getNewSearchUsernameScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ScnLogin.class.getResource("scnSearchUser.fxml"));
            return new Scene(fxmlLoader.load());
        }catch (Exception e){
            StageManager.getInstance().showErrorDialog("Unknown Error!");
            return getNewLoginScene();
        }
    }

}
