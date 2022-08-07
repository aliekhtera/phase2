package com.front;

import com.back.messengers.Group;
import com.back.usersPackage.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScnBanAndRemove {
     Group group;

    @FXML
    Label label ;

    public  void remove() {
        group.removeUser(group.getAdmin(), User.getSelectedUser(), group);
    }

    public  void ban() {
        group.banMember(group.getAdmin(), group, User.getSelectedUser().getUserName());
    }

    public void cancel() {

    }

    //@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
