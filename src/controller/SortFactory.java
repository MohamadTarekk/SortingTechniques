package controller;

import model.*;

import java.util.ArrayList;

class SortFactory {
    static Sort createNewSort(ArrayList<Integer> arrayList, String type) {
        switch (type) {
            case "Bubble Sort":
                return new BubbleSort(arrayList);
            case "Heap Sort":
                return new HeapSort(arrayList);
            case "Insertion Sort":
                return new InsertionSort(arrayList);
            case "Merge Sort":
                return new MergeSort(arrayList);
            case "Quick Sort":
                return new QuickSort(arrayList);
            case "Selection Sort":
                return new SelectionSort(arrayList);

            default:
                return null;
        }
    }
}
