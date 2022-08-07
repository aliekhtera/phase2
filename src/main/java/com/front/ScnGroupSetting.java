package com.front;

import com.back.messengers.Group;
import com.dataBase.DataBaseGetter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ScnGroupSetting {
     Group group = Group.getGroup();

    @FXML
     TextField txtGroupID, txtGroupName, txtAddNewMember;

    @FXML
    ImageView imgProfile;
    String pictureURL;
    static String nullUrl = String.valueOf(ScnGroupSetting.class.getResource("nullUserImage.png"));
    Label label;

    @FXML
     void groupEdit() {
        String url = imgProfile.getImage().getUrl();
        File file;
        if (url == null) {
            if (pictureURL == null) {
                file = null;
            } else {
                file = new File(pictureURL);
            }
        } else if (url.equals(nullUrl)) {
            file = null;
        }
        else {
            file = new File(url);
        }

        if (StageManager.getInstance().showDialog(Group.editGroup(txtGroupName.getText() ,  group.getMembers() , file, group.getGroupID()))){
            initialize(null, null);
        }

    }

    @FXML
     void members() {
        StageManager.getInstance().openNewStage(SceneManager.getInstance().getNewMembersScene(), "Members!", imgProfile.getScene().getWindow());
    }

    @FXML
    private void changeProfileImage() {
        String result = FrontManager.openImage(imgProfile);
        if (result != null) {
            pictureURL = result;
        }
    }

    @FXML
    void checkTxtAddNewMember() {
        FrontManager.textFieldSetter(txtAddNewMember, ControllerType.ADD_NEW_MEMBER);
    }

    @FXML
    void checkTxtGroupName() {
        FrontManager.textFieldSetter(txtGroupName, ControllerType.GROUP_NAME);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtGroupID.setText(group.getGroupID());
        txtGroupName.setText(group.getGroupName());
        txtAddNewMember.setText("Enter UserName");

        label.setText("Add new member :");

        Image groupP= DataBaseGetter.getInstance().getGroupProfile(group.getGroupID());
        if(groupP==null){
            imgProfile.setImage(new Image(nullUrl));
        }else{
            imgProfile.setImage(FrontManager.cropImage(groupP));
        }


    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
