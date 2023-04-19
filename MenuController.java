package a2048;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {
    @FXML
    public void startpress()throws IOException {
        Parent Game = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        StartGo.currentstage.setScene(GameScene);
    }
    public void leavepress(){
        StartGo.currentstage.close();
    }
}