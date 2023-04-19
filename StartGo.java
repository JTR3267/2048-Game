package a2048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGo extends Application {
    public static Stage currentstage;
    public static Scene menuscene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        currentstage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        menuscene = new Scene(root);
        primaryStage.setTitle("2048");
        primaryStage.setScene(menuscene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}