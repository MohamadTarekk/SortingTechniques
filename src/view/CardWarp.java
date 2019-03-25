package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

class CardWarp extends Canvas {

    private final GraphicsContext gc;
    private final double canvasWidth;
    private final double canvasHeight;

    CardWarp(double width, double height){
        this.setWidth(width);
        this.setHeight(height);
        canvasWidth = width;
        canvasHeight = height;
        gc = this.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fill();
        //Painting with MouseDragged Event
        //this.setOnMouseDragged(event -> gc.fillOval(event.getX(),   event.getY(), 25, 25));
    }

    void visualize(ArrayList<Integer> list){
        gc.setFill(Color.WHITE);
        gc.fill();
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
        //gc.clearRect(0,0,this.getWidth(),this.getHeight());
        int step;
        int width;
        if (list.size() <= canvasWidth) {
            step = 1;
            width = (int) (canvasWidth/list.size());
        }else{
            step = (int) (list.size()/canvasWidth);
            //System.out.println(step);
            width = 1;
        }
        int height = (int) (canvasHeight / Collections.max(list));
        Rectangle rectangle = new Rectangle();
        for (int i=0 ; i<list.size() ; i+=step){
            rectangle.setX(i*width);
            rectangle.setY(0);
            rectangle.setWidth(width);
            rectangle.setHeight(height * list.get(i));
            drawRectangle(rectangle);
            //System.out.println(i+"\t");
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
