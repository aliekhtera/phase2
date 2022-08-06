package com.front;

import com.back.messages.Message;
import com.back.messengers.Group;
import com.back.messengers.PV;

import com.back.messengers.Page;
import com.back.usersPackage.User;
import com.dataBase.DataBaseGetter;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ScnMain implements Initializable {
    @FXML
    ListView<String> lstUsers, lstMessengerGroups;
    @FXML
    Pane cpnMessengersList, cpnPageTitle, cpnGroupTitle, cpnPVTitle;
    @FXML
    ImageView imgTitle;
    @FXML
    Label lblTitle;
    @FXML
    private VBox vbxMessages;


    private List<PV> pvList;
    private List<Group> groupList;
    private List<Page> pageList;

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

    private Pane messageToPane(Message message) {
        double width = 530;
        ArrayList<Node> nodes = new ArrayList<>();

        ImageView profile = new ImageView(FrontManager.cropImage(DataBaseGetter.getInstance().getUserProfile(message.getSenderUserName())));
        profile.setFitWidth(0.15 * width);
        profile.setFitHeight(0.15 * width);
        nodes.add(profile);

        Label sender = new Label();
        sender.setWrapText(false);
        sender.setPrefWidth(width * 0.6);
        sender.setText(message.getSender().getUserName());
        sender.setLayoutX(width * 0.166);
        sender.setLayoutY(profile.getFitHeight() / 2);
        nodes.add(sender);

        double icnSize = (width * 0.6) / 9;
        double i = 0.16 * width;
        double y = width * 0.011;
        {
            ImageView tempIcn = new ImageView(FrontManager.getIcnLiked(message.isLoggedUserLiked()));
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setId("a" + message.getKeyID());
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    likeMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        {
            ImageView tempIcn = new ImageView(FrontManager.getIcnDelete());
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("c" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    deleteMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        {
            ImageView tempIcn = new ImageView(FrontManager.getIcnReply());
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("d" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    editMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        {
            ImageView tempIcn = new ImageView(FrontManager.getIcnEdited(message.getBooleanIsEdited()));
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("e" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    editMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        {
            ImageView tempIcn = new ImageView(FrontManager.getIcnForward(message.getBooleanIsForwarded()));
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("g" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    forwardMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        if (message.getRepliedTo() >= 0) {
            ImageView tempIcn = new ImageView(FrontManager.getIcnReplied());
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("h" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    getRepliedMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        if (DataBaseGetter.getInstance().getMessageFile(message) != null) {
            ImageView tempIcn = new ImageView(FrontManager.getIcnFile());
            tempIcn.setFitWidth(icnSize);
            tempIcn.setFitHeight(icnSize);
            tempIcn.setLayoutX(i);
            tempIcn.setLayoutY(y);
            tempIcn.setCursor(Cursor.HAND);
            tempIcn.setId("i" + message.getKeyID());
            tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    fileMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                }
            });
            nodes.add(tempIcn);
            i += icnSize * 1.1;
        }

        if (message.getSender().isUserNameEqual(User.getLoggedInUser().getUserName())) {
            {
                ImageView tempIcn = new ImageView(FrontManager.getIcnShowLikes());
                tempIcn.setFitWidth(icnSize);
                tempIcn.setFitHeight(icnSize);
                tempIcn.setLayoutX(i);
                tempIcn.setLayoutY(y);
                tempIcn.setCursor(Cursor.HAND);
                tempIcn.setId("j" + message.getKeyID());
                tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        showLikesMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                    }
                });
                nodes.add(tempIcn);
                i += icnSize * 1.1;
            }

            {
                ImageView tempIcn = new ImageView(FrontManager.getIcnViews());
                tempIcn.setFitWidth(icnSize);
                tempIcn.setFitHeight(icnSize);
                tempIcn.setLayoutX(i);
                tempIcn.setLayoutY(y);
                tempIcn.setCursor(Cursor.HAND);
                tempIcn.setId("k" + message.getKeyID());
                tempIcn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        showViewsMessageClick(((ImageView) mouseEvent.getSource()).getId().substring(1));
                    }
                });
                nodes.add(tempIcn);
            }
        }


        Label text = new Label(message.getText());
        text.setMouseTransparent(true);
        text.setWrapText(true);
        text.setPrefWidth(width * 0.8);
        text.setLayoutY(width * 0.13);
        text.setLayoutX(width * 0.16);
        nodes.add(text);


        Label sentTime = new Label(message.getSentTime());
        sentTime.setMouseTransparent(true);
        sentTime.setLayoutY(text.getLayoutY() + text.getHeight() + width * 0.02);
        sentTime.setLayoutX(width * 0.02);
        nodes.add(sentTime);

        Label sentDate = new Label(message.getSentDate());
        sentDate.setMouseTransparent(true);
        sentDate.setLayoutY(text.getLayoutY() + text.getHeight() + sentTime.getHeight() + width * 0.05);
        sentDate.setLayoutX(width * 0.02);
        nodes.add(sentDate);


        double h = Math.max(sentDate.getLayoutY() + sentDate.getHeight(), text.getLayoutY() + text.getHeight()) + width * 0.04;
        Pane result = new Pane();
        result.setPrefWidth(width);
        result.setPrefHeight(h);
        result.getChildren().addAll(nodes);
        result.setId(message.getStringKeyID());
        return result;
    }

    @FXML
    private void messengersListRefresh() {

        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() == 0) {
            ArrayList<String> temp = new ArrayList<>();
            pvList = DataBaseGetter.getInstance().getPVsOfUser(User.getLoggedInUser().getUserName());
            double i = 0;
            cpnMessengersList.setPrefHeight(lstUsers.getFixedCellSize() * (pvList.size() + 1));
            lstUsers.setPrefHeight(lstUsers.getFixedCellSize() * (pvList.size() + 1));
            for (PV pv : pvList) {
                temp.add("");
                User otherUser;
                if (pv.getUser1().isUserNameEqual(User.getLoggedInUser().getUserName())) {
                    otherUser = pv.getUser2();
                } else {
                    otherUser = pv.getUser1();
                }
                Image profile = DataBaseGetter.getInstance().getUserProfile(otherUser.getUserName());
                if (profile == null) {
                    profile = new Image(ScnSettings.nullUrl);
                }
                ImageView tempImageView = new ImageView(profile);
                Label unLabel = new Label(), dLabel = new Label();
                unLabel.setText(otherUser.getUserName());
                if (pv.getMessages().size() > 0) {
                    Message m = pv.getMessages().get(pv.getMessages().size() - 1);
                    dLabel.setText(m.getSentDate());
                } else {
                    dLabel.setText("No Message");
                }
                tempImageView.setFitWidth(lstUsers.getFixedCellSize() * 0.8);
                tempImageView.setFitHeight(lstUsers.getFixedCellSize() * 0.8);
                tempImageView.setLayoutY(lstUsers.getFixedCellSize() * (i + 0.1));
                tempImageView.setLayoutX(lstUsers.getFixedCellSize() * 0.1);
                unLabel.setLayoutX(lstUsers.getWidth() * 0.5);
                dLabel.setLayoutX(lstUsers.getWidth() * 0.5);
                unLabel.setLayoutY(lstUsers.getFixedCellSize() * (i + 0.1));
                dLabel.setLayoutY(lstUsers.getFixedCellSize() * (i + 0.5));
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

        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() == 1) {
            ArrayList<String> temp = new ArrayList<>();
            groupList = DataBaseGetter.getInstance().getGroupsOfUser(User.getLoggedInUser().getUserName());
            double i = 0;

            cpnMessengersList.setPrefHeight(lstUsers.getFixedCellSize() * (groupList.size() + 1));
            lstUsers.setPrefHeight(lstUsers.getFixedCellSize() * (groupList.size() + 1));
            for (Group group : groupList) {
                temp.add("");
                Image profile = DataBaseGetter.getInstance().getGroupProfile(group.getGroupID());
                if (profile == null) {
                    profile = new Image(ScnSettings.nullUrl);
                }
                ImageView tempImageView = new ImageView(profile);
                i++;
            }
        }
        // todo Group
    }

    @FXML
    private void messageFiller() {
        if (lstUsers.getSelectionModel().getSelectedIndex() < 0) {
            return;
        }
        titleFiller();
        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() == 0) {
            PV pv = pvList.get(lstUsers.getSelectionModel().getSelectedIndex());
            messageFiller(pv.getMessages());
            return;
        }

    }

    private void messageFiller(List<Message> messages){
        double l = 0;
        ArrayList<Pane> panes = new ArrayList<>();
        for (Message message : messages) {
            Pane temp = messageToPane(message);
            panes.add(temp);
            l += temp.getPrefHeight();
        }

        vbxMessages.getChildren().clear();
        vbxMessages.setPrefHeight(l);

        for (int i = panes.size() - 1; i >= 0; i--) {
            double w = vbxMessages.getWidth() - panes.get(i).getPrefWidth();
            if (messages.get(i).getSenderUserName().equals(User.getLoggedInUser().getUserName())) {
                w *= 3 / 4;
            } else {
                w *= 1 / 4;
            }
            panes.get(i).setLayoutX(w);
            vbxMessages.getChildren().add(panes.get(i));
        }

    }

    private void titleFiller() {
        if (lstUsers.getSelectionModel().getSelectedIndex() < 0) {
            imgTitle.setImage(null);
            lblTitle.setText("");
            cpnPVTitle.setVisible(false);
            cpnGroupTitle.setVisible(false);
            cpnPageTitle.setVisible(false);
            return;
        }

        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() == 0) {
            PV pv = pvList.get(lstUsers.getSelectionModel().getSelectedIndex());
            User otherUser;
            if (pv.getUser1().getUserName().equals(User.getLoggedInUser())) {
                otherUser = pv.getUser2();
            } else {
                otherUser = pv.getUser1();
            }
            Image image = DataBaseGetter.getInstance().getUserProfile(otherUser.getUserName());
            if (image == null) {
                image = new Image(ScnSettings.nullUrl);
            }
            imgTitle.setImage(FrontManager.cropImage(image));
            lblTitle.setText(otherUser.getFirstName() + " " + otherUser.getLastName());
            cpnPVTitle.setVisible(true);
            cpnGroupTitle.setVisible(false);
            cpnPageTitle.setVisible(false);
            return;
        }


    }

    private void search() {
        StageManager.getInstance().openNewStage(SceneManager.getInstance().getNewSearchScene(), "Search!");
    }

    //////////////// Message ///////////////////////////////////////
    private void likeMessageClick(String id) {

    }

    private void deleteMessageClick(String id) {

    }

    private void editMessageClick(String id) {

    }

    private void forwardMessageClick(String id) {

    }

    private void getRepliedMessageClick(String id) {
    }

    private void fileMessageClick(String id) {

    }

    private void showLikesMessageClick(String id) {

    }

    private void showViewsMessageClick(String id) {

    }

    ////////////////////// Group ///////////////////////
    @FXML
    private void removeUserGroup() {
      if(lstMessengerGroups.getSelectionModel().getSelectedIndex() != 1)  {
          if (lstUsers.getSelectionModel().getSelectedIndex() == -1) {
              groupList.get(lstUsers.getSelectionModel().getSelectedIndex());
          }
      }
    }

    @FXML
    private void banUserGroup() {
        if(lstMessengerGroups.getSelectionModel().getSelectedIndex() != 1)  {
            if (lstUsers.getSelectionModel().getSelectedIndex() == -1) {
                groupList.get(lstUsers.getSelectionModel().getSelectedIndex());
            }
        }
    }

    @FXML
    private void groupSettings() {
        if(lstMessengerGroups.getSelectionModel().getSelectedIndex() != 1)  {
            if (lstUsers.getSelectionModel().getSelectedIndex() == -1) {
                groupList.get(lstUsers.getSelectionModel().getSelectedIndex());
            }
        }
    }

    @FXML
    private void sendNewMessageGroup() {

    }

    /////////////////// PV //////////////////
    @FXML
    private void sendNewMessagePV() {
        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() != 0) {
            return;
        }
        if (lstUsers.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }
        PV pv = pvList.get(lstUsers.getSelectionModel().getSelectedIndex());
        User user;
        if(pv.getUser1().isUserNameEqual(User.getLoggedInUser().getUserName())){
            user=pv.getUser2();
        }else{
            user=pv.getUser1();
        }
        if(User.isLoggedUserBlocked(user.getUserName())){
            StageManager.getInstance().showErrorDialog("You Are Blocked.");
            return;
        }
        Message message = new Message(User.getLoggedInUser(),"","","",false,-1,false,new ArrayList<>(),new ArrayList<>());
        StageManager.getInstance().openNewStage(SceneManager.getInstance().getNewNewMessageScene(message, null, false),"New Message");
        pv.getMessages().add(message);
    }
    @FXML
    private void blockPV() {
        if (lstMessengerGroups.getSelectionModel().getSelectedIndex() != 0) {
            return;
        }
        if (lstUsers.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }
        PV pv = pvList.get(lstUsers.getSelectionModel().getSelectedIndex());
        User user;
        if(pv.getUser1().isUserNameEqual(User.getLoggedInUser().getUserName())){
            user=pv.getUser2();
        }else{
            user=pv.getUser1();
        }
        User.blockUnBlockUser(user.getUserName());
    }



}
