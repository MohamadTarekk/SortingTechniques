package model;

import java.util.ArrayList;

import controller.ArrayGenerator;
import javafx.util.Pair;

public class MergeSort extends Sort {

	public MergeSort(ArrayList<Integer> array) {
		sortingTechnique = "Merge Sort";
		this.arr = array;
	}
	
	/* Divide and conquer algorithm
	 * Split and Merge
	 * If the array is of odd length the extra element goes to the right subarray
	 */
	
	public void sort(){
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			
			mergeSort(arr, 0, lengthOfNewArray-1);
			
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<>(sortedLength, time);
			NTime.add(p);

		}
	}
	
	private void mergeSort(ArrayList<Integer> arr , int start, int end) {
		if(start < end) {
			int middle = (end + start) / 2;
			mergeSort(arr, start , middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start , middle ,end);
		}
	}
	
	private void merge(ArrayList<Integer> arr , int start , int middle , int end) {

		int leftIndex = start;
		int rightIndex = middle + 1 ;
		ArrayList<Integer> temp = new ArrayList<>();
		int tempIndex = 0;
		while(leftIndex<=middle && rightIndex<=end) {
			if(arr.get(leftIndex) <= arr.get(rightIndex)) {
				temp.add(tempIndex,arr.get(leftIndex));
				leftIndex++;
				tempIndex++;
			}else {
				temp.add(tempIndex,arr.get(rightIndex));
				rightIndex++;
				tempIndex++;

			}
			/*
			 * Write the smaller element into the temp array
			 * We use equal to preserve the order of duplicate items	 */
		}		
		//Either of below while loop will execute
		while(leftIndex<=middle) {
			temp.add(tempIndex,arr.get(leftIndex));
			leftIndex++;
			tempIndex++;
		}
		while(rightIndex <= end) {
			temp.add(tempIndex,arr.get(rightIndex));
			rightIndex++;
			tempIndex++;
		}

		//Copy from the temp array to the main array
		for(int i = start , j = 0; j < temp.size() ; i++, j++) {
			arr.set(i, temp.get(j));
		}
	}
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}
	
}
