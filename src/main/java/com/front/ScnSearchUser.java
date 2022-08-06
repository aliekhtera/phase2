package com.front;

import com.back.messengers.PV;
import com.back.messengers.Page;
import com.back.usersPackage.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ScnSearchUser implements Initializable{

    @FXML
    Label userName, firstName, lastName, userName1, firstName1, lastName1;

    @FXML
    public void unfollow() {
        System.out.println("========");
    }

    @FXML
    public void follow() {
        System.out.println("zzzzzzzzz");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(User.getSelectedUser().getUserName());
        firstName.setText(User.getSelectedUser().getFirstName());
        lastName.setText(User.getSelectedUser().getLastName());
        userName1.setText("Username");
        firstName1.setText("Firstname");
        lastName1.setText("Lastname");
    }

}
