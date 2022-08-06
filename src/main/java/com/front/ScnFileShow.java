package com.front;

import com.back.MethodReturns;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;

public class ScnFileShow {
    private Blob blob;
    private String fileName;
    @FXML
    private ImageView imgPicture,imgFile;

    void init(Blob blob,String fileName){
        this.blob=blob;
        this.fileName=fileName;
        String format=fileName.substring(fileName.indexOf("."));
        if(format.equals(".png") || format.equals(".jpg") || format.equals(".jpeg")){
            imgPicture.setVisible(true);
            imgFile.setVisible(false);
            try {
                imgPicture.setImage(new Image(blob.getBinaryStream()));
            }catch (Exception e){
                imgPicture.setImage(null);
            }
        }else{
            imgPicture.setVisible(false);
            imgFile.setVisible(true);
        }
    }
    @FXML
    private void save(){
        FileChooser fileChooser=new FileChooser();
        String ex="*"+fileName.substring(fileName.indexOf("."));
        FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter(ex,ex);
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file=fileChooser.showSaveDialog(imgFile.getScene().getWindow());
        System.out.println(file.toString());
        try {
            FileOutputStream fos = new FileOutputStream(file.toString()+fileName.substring(fileName.indexOf(".")));
            byte[] l=blob.getBytes(1,(int) blob.length());
            for (int i = 0; i < l.length; i++) {
                fos.write(l[i]);
            }
            if(fos!=null){
                fos.close();
            }
            StageManager.getInstance().showDoneDialog();
        }catch (Exception e){
            StageManager.getInstance().showDialog(MethodReturns.UNKNOWN_FRONT_ERROR);
        }
    }


}
