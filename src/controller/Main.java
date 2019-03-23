package controller;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	private static final int WIDTH = 600;
	private static final int HEIGTH = 400;

	@Override
	public void start(Stage primaryStage) {
		//handling the canvas
		final Canvas canvas = new Canvas(WIDTH, HEIGTH);
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.AQUA);
		gc.fill();
		//Painting with MouseDragged Event
		canvas.setOnMouseDragged(event -> gc.fillOval(event.getX(),   event.getY(), 25, 25));
		//User a ColorPicke for Color of Painting
		ColorPicker cp = new ColorPicker();
		cp.setOnAction(e -> gc.setFill(cp.getValue()));
		//Layout
		BorderPane root = new BorderPane();
		HBox hb = new HBox(30);
		Button button = new Button("Clear all");

		button.setOnAction(e ->
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));
		hb.getChildren().addAll(cp, button);
		hb.setPrefHeight(200);
		hb.setAlignment(Pos.CENTER);
		root.setCenter(canvas);
		root.setBottom(hb);
		final Scene scene = new Scene(root);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}