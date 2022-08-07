package com.front;

import com.back.messages.Message;
import com.back.messengers.Page;
import com.back.usersPackage.User;
import com.back.usersPackage.UserType;
import com.dataBase.DataBaseGetter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Blob;

public class ApnPost {
    Message post;
    Page page;
    @FXML
    ImageView imgDelete, imgLike, imgViews, imgPic;
    @FXML
    Label lblText,lblSender,lblTime;

    public void setClass(Message post, Page page, Blob blob) {
        this.page = page;
        this.post = post;
        imgLike.setImage(new Image(FrontManager.getIcnLiked(post.isLoggedUserLiked())));
        imgViews.setImage(new Image(FrontManager.getIcnViews(post.getViews().size())));
        try {
            imgPic.setImage(new Image(blob.getBinaryStream()));
        } catch (Exception e) {
        }
        lblText.setText(post.getText());
        lblSender.setText(page.getPageName());
        imgDelete.setVisible(post.getSender().isUserNameEqual(User.getLoggedInUser().getUserName()));
        imgViews.setVisible(post.getSender().isUserNameEqual(User.getLoggedInUser().getUserName()));
        lblText.setText(post.getText());
    }

    @FXML
    private void delete(){
        page.deletePost(post.getKeyID());
        ScnMain.getScnMain().listsRefresh();
    }
    @FXML
    private void like(){
        post.likeDislikeByLoggedInUser();
        ScnMain.getScnMain().listsRefresh();
    }
    @FXML
    private void comments(){
        ScnMain.getScnMain().listsRefresh();
    }
    @FXML
    private void views(){
        if(post.getSender().getUserType().equals(UserType.NORMAL_USER)){

        }else{

        }
        ScnMain.getScnMain().listsRefresh();
    }
    @FXML
    private void showLikes(){
        if(post.getSender().getUserType().equals(UserType.NORMAL_USER)){

        }else{

        }
        ScnMain.getScnMain().listsRefresh();
    }

}