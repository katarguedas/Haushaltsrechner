package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Haushaltsrechner extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {
		try {
			
//			Scene scene = new Scene();
//			primaryStage.setTitle();
			primaryStage.setMaxHeight(900);
			primaryStage.setMaxWidth(800);
//			primaryStage.setScene(scene);
			primaryStage.show();
			//...
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	

	}

}