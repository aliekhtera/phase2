package com.front;

import com.back.messengers.Group;
import com.back.usersPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScnSearchGroup implements Initializable {
    @FXML
    Label groupName, groupMembers, groupAdmin;

    public void join() {
        User admin = Group.getGroup().getAdmin();
        Group.getGroup().addUser(admin, User.getLoggedInUser(), Group.getGroup());
    }

    public void leave() {
        User admin = Group.getGroup().getAdmin();
        Group.getGroup().removeUser(admin, User.getLoggedInUser(), Group.getGroup());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupName.setText(Group.getGroup().getGroupName());
        groupMembers.setText(Integer.toString(Group.getGroup().getMembers().size()) + "members");
        groupAdmin.setText(Group.getGroup().getAdmin().getUserName());
    }

}
