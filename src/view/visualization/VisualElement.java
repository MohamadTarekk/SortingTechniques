package view.visualization;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VisualElement extends Rectangle {

    private Color notSelected = Color.web("#DC143C");
    private Color selected = Color.web("#FFFF00");
    private Color sorted = Color.web("#4B0082");
    private Color current = notSelected;

    public VisualElement(double x, double y, double w, double h){
        setX(x);
        setY(y);
        setWidth(w);
        setHeight(h);
    }

    public Color getCurrentColor(){
        return current;
    }

    public void setCurrentColor(int a){
        switch (a){
            case 0:
                current = notSelected;
                break;
            case 1:
                current = selected;
                break;
            case 2:
                current = sorted;
                break;
            default:
                current = notSelected;
        }
    }
}
