package model;

import java.util.ArrayList;

import javafx.util.Pair;

public class MergeSort {
	public static ArrayList<Pair<Integer,Long>> mergeNTime = new ArrayList<Pair<Integer,Long>>(20);
	private ArrayList<Integer> arr;
	private int numberOfArrays = 10;
	private int sortedLength = 0;
	
	public MergeSort(ArrayList<Integer> array) {
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
			int lengthOfNewArray = (int)(length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			mergeSort(arr, 0, lengthOfNewArray-1);
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<Integer, Long>(sortedLength , time);
			mergeNTime.add(p);

		}
	}
	
	private void mergeSort(ArrayList<Integer> arr , int start, int end) {
		if(start < end && (end - start) >= 1 ) {
			int middle = (end + start) / 2;
			mergeSort(arr, start , middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start , middle ,end);
		}
	}
	
	private void merge(ArrayList<Integer> arr , int start , int middle , int end) {
		/*If the last element in the left partition is less than or equal the first element in the right partition
		 *This mean that all the elements of the left partition is less than the first element in the right parition
		 *Stick the two arrays together 
		 */		
		int leftIndex = start;
		int rightIndex = middle + 1 ;
		//int tempIndex = 0; //Keep track where we are in the temp array
		ArrayList<Integer> temp = new ArrayList<Integer>();
		/*
		 * When leftIndex = mid we'll have finished traversing the left array , rightIndex = end we'll have finished traversing the right array
		 * so we want to drop out
		 */
		while(leftIndex<=middle && rightIndex<=end) {
			if(arr.get(leftIndex) <= arr.get(rightIndex)) {
				temp.add(arr.get(leftIndex));
				leftIndex++;
			}else {
				temp.add(arr.get(rightIndex));
				rightIndex++;
			}
			/*
			 * Write the smaller element into the temp array
			 * We use equal to preserve the order of duplicate items	 */
		}		
		//Either of below while loop will execute
		while(leftIndex<=middle) {
			temp.add(arr.get(leftIndex));
			leftIndex++;
		}
		while(rightIndex <= end) {
			temp.add(arr.get(rightIndex));
			rightIndex++;
		}
        int i = 0;
        int j = start;
        //Setting sorted array to original one
        while(i<temp.size()){
            arr.set(j, temp.get(i++));
            j++;
        }
		/*
		
		 * Handling the remaining element in the array we didn't finish traversing
		 * {32 , 34} , {33 , 36}
		 *  {32 , 33 , 34}
		 *  if we have elements left over in the right array do nothing because we'll copy the temp array
		 *  to the position that they occupy in the original array
		 *  if We add the 36 we'll do needless work
		 */
		
		/*
		 * We copy at position i because if there are any leftover in the left array i is the index
		 * of the first elements we still haven't handled
		 * 
		 * middle - i tell us the number of elements that we didn't copy over into the temp array from the left parition
		 */
	}
	
	
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}
	
}
