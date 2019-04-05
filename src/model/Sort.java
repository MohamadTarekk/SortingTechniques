package model;

import javafx.scene.chart.XYChart;
import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Sort {

    ArrayList<Integer> arr;
    ArrayList<Pair<Integer,Long>> NTime = new ArrayList<>(20);
    int numberOfArrays = 10;
    int sortedLength = 0;
    String sortingTechnique;

    public void sort(){}

    public XYChart.Series<String, Number> getCoordinates(){
        XYChart.Series<String, Number> coordinates = new XYChart.Series<>();
        coordinates.getData().add(new XYChart.Data<>("0",  0));
        for(Pair<Integer, Long> p : NTime)
        {
            coordinates.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinates.setName(sortingTechnique);
        return coordinates;
    }
}
