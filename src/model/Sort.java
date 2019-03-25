package model;

import javafx.scene.chart.XYChart;
import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Sort {

    protected ArrayList<Integer> arr;
    protected static ArrayList<Pair<Integer,Long>> NTime = new ArrayList<Pair<Integer,Long>>(20);
    protected int numberOfArrays = 10;
    protected int sortedLength = 0;

    public void sort(){}
    private XYChart.Series<String, Number> coordinates = new XYChart.Series<>();

    public XYChart.Series<String, Number> getCoordinates(){
        for(Pair<Integer, Long> p : NTime)
        {
            coordinates.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        return coordinates;
    }
}
