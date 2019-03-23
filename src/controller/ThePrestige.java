package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

//import model.*;
//import model.*;

public class ThePrestige extends Application {

	public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString() + "\\src\\view\\TheStage.fxml";
        Parent root = FXMLLoader.load(new File(path).toURI().toURL());
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1300, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
