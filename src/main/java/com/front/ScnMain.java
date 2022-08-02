package com.front;

import com.back.messages.Message;
import com.back.messengers.PV;

import com.back.usersPackage.User;
import com.dataBase.DataBaseGetter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScnMain implements Initializable {
    @FXML
    ListView<String> lstUsers,lstMessengerGroups;
    @FXML
    Pane cpnMessengersList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        {
            ArrayList temp = new ArrayList();
            for (int i = 0; i < 3; i++) {
                temp.add("");
            }
            lstMessengerGroups.setItems(FXCollections.observableList(temp));
        }
       // lstUsers.setItems(FXCollections.observableList(m));
    }
@FXML
    void messengersListRefresh() {

        if (lstMessengerGroups.getSelectionModel().getSelectedIndex()==0) {
            ArrayList<String> temp=new ArrayList<>();
            ArrayList<PV> pvs = DataBaseGetter.getInstance().getPVsOfUser(User.getLoggedInUser().getUserName());
            double i=0;
            cpnMessengersList.setPrefHeight(lstUsers.getFixedCellSize()*(pvs.size()+1));
            lstUsers.setPrefHeight(lstUsers.getFixedCellSize()*(pvs.size()+1));
            for (PV pv : pvs) {
                temp.add("");
                User otherUser;
                if(pv.getUser1().isUserNameEqual(User.getLoggedInUser().getUserName())){
                    otherUser=pv.getUser2();
                }else{
                    otherUser=pv.getUser1();
                }
                Image profile=DataBaseGetter.getInstance().getUserProfile(otherUser.getUserName());
                if(profile==null){
                    profile=new Image(ScnSettings.nullUrl);
                }
                ImageView tempImageView=new ImageView(profile);
                Label unLabel=new Label() , dLabel=new Label();
                unLabel.setText(otherUser.getUserName());
                if(pv.getMessages().size()>0){
                    Message m=pv.getMessages().get(pv.getMessages().size()-1);
                    dLabel.setText(m.getSentDate());
                }else{
                    dLabel.setText("No Message");
                }
                tempImageView.setFitWidth(lstUsers.getFixedCellSize()*0.8);
                tempImageView.setFitHeight(lstUsers.getFixedCellSize()*0.8);
                tempImageView.setLayoutY(lstUsers.getFixedCellSize()*(i+0.1));
                tempImageView.setLayoutX(lstUsers.getFixedCellSize()*0.1);
                unLabel.setLayoutX(lstUsers.getWidth()*0.5);
                dLabel.setLayoutX(lstUsers.getWidth()*0.5);
                unLabel.setLayoutY(lstUsers.getFixedCellSize()*(i+0.1));
                dLabel.setLayoutY(lstUsers.getFixedCellSize()*(i+0.5));
                tempImageView.setMouseTransparent(false);
                dLabel.setMouseTransparent(false);
                unLabel.setMouseTransparent(false);
                cpnMessengersList.getChildren().add(dLabel);
                cpnMessengersList.getChildren().add(unLabel);
                cpnMessengersList.getChildren().add(tempImageView);
                i++;
            }
            lstUsers.setItems(FXCollections.observableList(temp));

        }

        // todo Group

    }



}
