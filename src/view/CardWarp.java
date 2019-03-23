package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

class CardWarp extends Canvas {

    private final GraphicsContext gc;

    CardWarp(double width, double height){
        this.setWidth(width);
        this.setHeight(height);
        gc = this.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fill();
        //Painting with MouseDragged Event
        this.setOnMouseDragged(event -> gc.fillOval(event.getX(),   event.getY(), 25, 25));
    }

    void visualSort(ArrayList<Integer> list){
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        int step;
        int width;
        if (list.size() <= 500) {
            step = 1;
            width = 500/list.size();
        }else{
            step = (list.size()/500);
            width = 1;
        }
        int height = 600 / Collections.max(list);
        for (int i=0 ; i<list.size() ; i+=step){
            drawRectangle(new Rectangle(i*width, 0, width, list.get(i)*height));
        }
    }

    private void drawRectangle(Rectangle rect){
        gc.setFill(Color.RED);
        gc.fillRect(rect.getX(),
                rect.getY(),
                rect.getWidth(),
                rect.getHeight());
        //gc.setFill(Color.GREEN);
        //gc.setStroke(Color.BLUE);
        //return gc;
    }
}
