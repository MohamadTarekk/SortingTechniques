package controller;

import view.visualization.BubbleSortVisual;
import view.visualization.SortVisual;

public class SortVisualFactory {

    public static SortVisual createNewSort(double width, double height, String type) {
        switch (type) {
            case "Bubble Sort":
                return new BubbleSortVisual(width, height);
            case "Heap Sort":
                // TODO
                return null;
            case "Insertion Sort":
                // TODO
                return null;
            case "Merge Sort":
                // TODO
                return null;
            case "Quick Sort":
                // TODO
                return null;
            case "Selection Sort":
                // TODO
                return null;
            default:
                return null;
        }
    }
}