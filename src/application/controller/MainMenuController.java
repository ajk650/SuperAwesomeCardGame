package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainMenuController implements Initializable{

    @FXML
    private AnchorPane mainScreen;

    @FXML
    private ImageView startBtn;

    @FXML
    private ImageView leaderBtn;
    
    public MediaPlayer playAudio;
    public Media audio;

    @FXML
    void startHandle(MouseEvent event) throws IOException {
    	System.out.println("Game Start Button");
    	URL url = new File("src/application/view/Game.fxml").toURI().toURL();
    	FXMLLoader parent = new FXMLLoader(url);
        Parent root = parent.load();
        System.out.println("[**] playAudio: " + playAudio);
        playAudio.pause();
        GameController gc = parent.getController();
//        gc.play(playAudio, "battletheme.mp3");
        Scene scene = new Scene(root);	
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();	
    }

    @FXML
    void leaderHandle(MouseEvent event) throws IOException {
    	System.out.println("Leaderboard Button");
    	URL url = new File("src/application/view/Leaderboard.fxml").toURI().toURL();
    	FXMLLoader parent = new FXMLLoader(url);
        Parent root = parent.load();
        System.out.println("[**] playAudio: " + playAudio);
        playAudio.pause();
        LeaderboardController leader = parent.getController();
//        gc.play(playAudio, "battletheme.mp3");
        Scene scene = new Scene(root);	
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();	
    }


	public MediaPlayer play(MediaPlayer playAudio, String audioTrack) throws MalformedURLException {
		
		URL url = new File("resources/audio/" + audioTrack).toURI().toURL();

		//audio = new Media("./audio/rick.mp3"); //does not work need to use URL like Anchor pane
		audio = new Media(url.toString());
		
		playAudio = new MediaPlayer(audio);
		playAudio.setVolume(0.15);
		playAudio.play();
//		System.out.println("[**] playAudio play: " + playAudio);
		return playAudio;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			playAudio = play(playAudio, "menutheme.wav");
//			System.out.println("[**] playAudio init: " + playAudio);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
