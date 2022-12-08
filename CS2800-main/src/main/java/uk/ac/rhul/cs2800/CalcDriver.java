package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This is the driver class for the application, it creates runs the GUI. 
 * @author sonishkandel
 *
 */
public class CalcDriver extends Application {


  /**
   * the main method for the driver, uses args for terminal/console input.
   * @param args xyz.
   */
  public static void main(String[] args) {
    launch(args);

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));

    Scene scene1 = new Scene(root, 600, 330);
    primaryStage.setTitle("Calculator by SK"); 
    primaryStage.setScene(scene1);
    primaryStage.setResizable(false);
    primaryStage.show();





  }


}
