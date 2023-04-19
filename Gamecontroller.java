package a2048;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Gamecontroller implements Initializable, EventHandler<KeyEvent> {
    @FXML
    public ImageView image1;
    @FXML
    public ImageView image2;
    @FXML
    public ImageView image3;
    @FXML
    public ImageView image4;
    @FXML
    public ImageView image5;
    @FXML
    public ImageView image6;
    @FXML
    public ImageView image7;
    @FXML
    public ImageView image8;
    @FXML
    public ImageView image9;
    @FXML
    public ImageView image10;
    @FXML
    public ImageView image11;
    @FXML
    public ImageView image12;
    @FXML
    public ImageView image13;
    @FXML
    public ImageView image14;
    @FXML
    public ImageView image15;
    @FXML
    public ImageView image16;
    @FXML
    public GridPane maze;
    @FXML
    public Button backbutton;
    @FXML
    public Button resumebutton;
    @FXML
    public Button restartbutton;
    @FXML
    public Group paulse;
    @FXML
    public Group lose;
    @FXML
    public Label lostext;
    @FXML
    public Group win;
    @FXML
    public Pane pane1;
    @FXML
    public Label highestscore;

    Image image_0 = new Image("/a2048/0_pixel.png");
    Image image_2 = new Image("/a2048/2_pixel.jpg");
    Image image_4 = new Image("/a2048/4_pixel.png");
    Image image_8 = new Image("/a2048/8_pixel.png");
    Image image_16 = new Image("/a2048/16_pixel.png");
    Image image_32 = new Image("/a2048/32_pixel.png");
    Image image_64 = new Image("/a2048/64_pixel.png");
    Image image_128 = new Image("/a2048/128_pixel.png");
    Image image_256 = new Image("/a2048/256_pixel.png");
    Image image_512 = new Image("/a2048/512_pixel.png");
    Image image_1024 = new Image("/a2048/1024_pixel.png");
    Image image_2048 = new Image("/a2048/2048_pixel.png");
    Game game1 = new Game();
    Game check = new Game();
    boolean cont =true;

    @FXML
    public void onBackPressed(){
        StartGo.currentstage.setScene(StartGo.menuscene);
    }
    @FXML
    public void onResumePressed(){
        paulse.setVisible(false);
        pane1.setVisible(false);
        maze.requestFocus();
        cont=true;
    }
    @FXML
    public void onRestartPressed(){
        game1.restart();
        paulse.setVisible(false);
        pane1.setVisible(false);
        maze.requestFocus();
        lose.setVisible(false);
        win.setVisible(false);
        move();
        cont=true;
    }
    @Override
    public void handle(KeyEvent e) {
        if(cont == true){
            if (e.getCode() == KeyCode.UP) {
                check.copy(game1);
                check.up();
                if (check.compare(game1) == 1) {
                    game1.up();
                    game1.getnewindex();
                }
            }
            else if (e.getCode() == KeyCode.DOWN) {
                check.copy(game1);
                check.down();
                if (check.compare(game1) == 1) {
                    game1.down();
                    game1.getnewindex();
                }
            }
            else if (e.getCode() == KeyCode.LEFT) {
                check.copy(game1);
                check.left();
                if (check.compare(game1) == 1) {
                    game1.left();
                    game1.getnewindex();
                }
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                check.copy(game1);
                check.right();
                if (check.compare(game1) == 1) {
                    game1.right();
                    game1.getnewindex();
                }
            }
            else if(e.getCode() == KeyCode.ESCAPE){
                cont=false;
                pane1.setVisible(true);
                paulse.setVisible(true);
                paulse.requestFocus();
            }
        }
        if(game1.getmax()>Highestscore.highestscore){
            Highestscore.highestscore=game1.getmax();
        }
        move();
        highestscore.setText("Highest Score: " + Highestscore.highestscore);
        if(game1.getmax() == 2048){
            pane1.setVisible(true);
            win.setVisible(true);
            win.requestFocus();
        }
        else if(game1.numamount() == 16){
            if(game1.checklose()==0){
                lostext.setText("You lose! Highest score: "+game1.getmax());
                pane1.setVisible(true);
                lose.setVisible(true);
                lose.requestFocus();
            }
        }
    }
    public void move(){
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                int num = game1.getarr(i,j);
                if(i==1&&j==1) {
                    setimage(image1,num);
                }
                else if(i==1&&j==2){
                    setimage(image2,num);
                }
                else if(i==1&&j==3){
                    setimage(image3,num);
                }
                else if(i==1&&j==4){
                    setimage(image4,num);
                }
                else if(i==2&&j==1){
                    setimage(image5,num);
                }
                else if(i==2&&j==2){
                    setimage(image6,num);
                }
                else if(i==2&&j==3){
                    setimage(image7,num);
                }
                else if(i==2&&j==4){
                    setimage(image8,num);
                }
                else if(i==3&&j==1){
                    setimage(image9,num);
                }
                else if(i==3&&j==2){
                    setimage(image10,num);
                }
                else if(i==3&&j==3){
                    setimage(image11,num);
                }
                else if(i==3&&j==4){
                    setimage(image12,num);
                }
                else if(i==4&&j==1){
                    setimage(image13,num);
                }
                else if(i==4&&j==2){
                    setimage(image14,num);
                }
                else if(i==4&&j==3){
                    setimage(image15,num);
                }
                else{
                    setimage(image16,num);
                }
            }
        }
    }
    public void setimage(ImageView y,int x){
        if(x==0){
            y.setImage(image_0);
        }
        else if(x==2){
            y.setImage(image_2);
        }
        else if(x==4){
            y.setImage(image_4);
        }
        else if(x==8){
            y.setImage(image_8);
        }
        else if(x==16){
            y.setImage(image_16);
        }
        else if(x==32){
            y.setImage(image_32);
        }
        else if(x==64){
            y.setImage(image_64);
        }
        else if(x==128){
            y.setImage(image_128);
        }
        else if(x==256){
            y.setImage(image_256);
        }
        else if(x==512){
            y.setImage(image_512);
        }
        else if(x==1024){
            y.setImage(image_1024);
        }
        else{
            y.setImage(image_2048);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        move();
        if(game1.getmax()>Highestscore.highestscore){
            Highestscore.highestscore=game1.getmax();
        }
        highestscore.setText("Highest Score: " + Highestscore.highestscore);
    }
}