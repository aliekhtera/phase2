package com.front;

import com.back.messengers.Group;
import com.back.usersPackage.User;
import com.back.usersPackage.UserType;
import com.dataBase.DataBaseGetter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ScnSearch implements Initializable {

    @FXML
    TextField txtID;
    @FXML
    private ChoiceBox<String > stringChoiceBox;
    @FXML
    Label label;

    private String[] type = {"Group", "User"};

    public void searchGroupID() {
        Group.setGroup(DataBaseGetter.getInstance().getGroup(txtID.getText()));
        StageManager.getInstance().openNewStage(SceneManager.getInstance().getNewSearchGroupScene(), "Result!");
    }

    public void searchUserID() {
        User.setSelectedUser(DataBaseGetter.getInstance().getUser(txtID.getText()));
        StageManager.getInstance().openNewStage(SceneManager.getInstance().getNewSearchUsernameScene(), "Result!");
    }

    public void checkID() {
        String s = getType();
        if (s == "User") {
            FrontManager.textFieldSetter(txtID, ControllerType.OLD_USERNAME);
        } else {
            FrontManager.textFieldSetter(txtID, ControllerType.GROUP_ID);
        }
    }

    public void check() {
        String choice = stringChoiceBox.getValue();
        if (choice == "Group") {
            searchGroupID();
        } else {
            searchUserID();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //stringChoiceBox.getItems().addAll(type);
        stringChoiceBox.setItems(FXCollections.observableList(Arrays.stream(type).toList()));
        stringChoiceBox.getSelectionModel().select(0);
        label.setText("Search");
    }

    public String  getType() {
        String type = stringChoiceBox.getValue();
        return type;
    }

}
