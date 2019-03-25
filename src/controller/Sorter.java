package controller;

import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import model.Sort;

public class Sorter {

    private Sort sort;

	public Sorter(ArrayList<Integer> array, String sortingTechnique) {
		sort = SortFactory.createNewSort(array, sortingTechnique);
		if (sort != null) {
			sort.sort();
		}
	}

	public XYChart.Series<String, Number> getCoordinates(){
		return sort.getCoordinates();
	}
}
