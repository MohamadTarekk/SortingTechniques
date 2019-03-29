package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.ArrayGenerator;
import javafx.util.Pair;

public class HeapSort extends Sort {
	
	
	public HeapSort(ArrayList<Integer> array) {
		sortingTechnique = "Heap Sort";
		this.arr = array;
	}

	
	private void buildMaxHeap(ArrayList<Integer> array, int size) {
		for(int i = size / 2 - 1 ; i >= 0; i--) {
			heapify(array, i, size);
		}
	}
  


    private void heapify(ArrayList<Integer> array, int index, int size) {
    	int left = getLeftChild(index);
    	int right = getRightChild(index);
    	int largest = index;
    	if(left < size && array.get(left) > array.get(largest)) {
    		largest = left;
    	}
    	if(right < size && array.get(right) > array.get(largest)) {
    		largest = right;
    	}
    	if(largest != index) {
    		swap(array,index,largest);
    		heapify(array,largest,size);
    	}
    }

  
	public void sort() 
    { 
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			
			buildMaxHeap(arr,lengthOfNewArray);
			int heapSize = lengthOfNewArray;
			for(int i = lengthOfNewArray - 1; i >= 0; i--) {
				swap(arr,0,i);
				heapSize--;
				heapify(arr, 0, heapSize);
			}
			
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<>(sortedLength, time);
			NTime.add(p);
		}
    }
	
	private int getLeftChild(int i) {
		return ((2 * i) + 1);
	}
	
	private int getRightChild(int i) {
		return ((2 * i) + 2);
	}
	
	private void swap(ArrayList<Integer> array , int i, int j) {
		Collections.swap(array, i, j);
	}
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}
	


}
