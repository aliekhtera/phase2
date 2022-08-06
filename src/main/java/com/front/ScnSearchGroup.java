package com.front;

import com.back.messengers.Group;
import com.back.usersPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ScnSearchGroup implements Initializable {

    Group group;

    @FXML
    Label groupName, groupMembers, groupAdmin;

    @FXML
    public void join() {
        User admin = Group.getGroup().getAdmin();
        Group.getGroup().addUser(admin, User.getLoggedInUser(), Group.getGroup());
    }

    @FXML
    public void leave() {
        User admin = Group.getGroup().getAdmin();
        Group.getGroup().removeUser(admin, User.getLoggedInUser(), Group.getGroup());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("]}}}}}}}}}}}}}}}}}}}}}}}}}");
        groupName.setText(group.getGroupName());
        groupMembers.setText(Integer.toString(group.getMembers().size()));
        groupAdmin.setText(group.getAdmin().getUserName());
    }


}
