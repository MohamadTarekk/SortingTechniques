package view.visualization;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class SortVisual extends Canvas {

    AnimationTimer animationTimer;
    ArrayList<VisualElement> list = new ArrayList<>(50);
    private final GraphicsContext gc;

    SortVisual(double width, double height){
        // setting the canvas
        this.setWidth(width);
        this.setHeight(height);
        gc = this.getGraphicsContext2D();
        // initializing the elements to be sorted
        double elementWidth = width/list.size();
        for (int i = 0 ; i < 50 ; i++){
            VisualElement r = new VisualElement(i* elementWidth, 0, elementWidth, randomHeight());
            list.add(i, r);
        }
    }

    private int randomHeight(){
        Random r = new Random();
        return r.nextInt(150);
    }

    void dimElement(int index){
        list.get(index).setCurrentColor(0);
    }

    void highlightElement(int index){
        list.get(index).setCurrentColor(1);
    }

    void setElementSorted(int index){
        list.get(index).setCurrentColor(2);
    }

    private void drawElement(VisualElement v){
        gc.setFill(v.getCurrentColor());
        gc.fill();
        gc.fillRect(v.getX(), v.getY(), v.getWidth(), v.getHeight());
    }

    void visualize(){
        gc.setFill(Color.web( "#bebcc3"));
        gc.fill();
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (VisualElement v : list){
            drawElement(v);
        }
    }
}
