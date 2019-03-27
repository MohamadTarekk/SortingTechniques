package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.ArrayGenerator;
import javafx.util.Pair;

public class QuickSort extends Sort {

	public QuickSort(ArrayList<Integer> array) {
		sortingTechnique = "Quick Sort";
		this.arr = array;
	}
	


    public void sort() {
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			
			quickSort(arr, 0, lengthOfNewArray - 1);
			
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<>(sortedLength, time);
			NTime.add(p);
		}
    }
    
    
    /* This function takes last element as pivot, 
     * places the pivot element at its correct 
     * position in sorted array, and places all 
     * smaller (smaller than pivot) to left of 
     * pivot and all greater elements to right 
     * of pivot 
     * */
    private int partition(ArrayList<Integer> array, int start, int end) 
    {
		int pivot = array.get(end);
		int lastSmall = start - 1;
		for(int i = start; i <= end ; i++) {
            // If current element is smaller than or 
            // equal to pivot
			if(arr.get(i) <= pivot) {
				lastSmall++;
				swap(array,lastSmall,i);
			}
		}
		//swap(array,end,lastSmall + 1);
		// Return the place of pivot
		return lastSmall;
    }
    
	// Generates Random Pivot, swaps pivot with 
	// end element and calls the partition function 
    private int randomizedPartition(ArrayList<Integer> array , int start , int end) {
		int randomPivotIndex =  (int)(Math.random()*((end-start)+1))+start;
		swap(array,end,randomPivotIndex);
		return partition(array,start,end);
    }
    
    /*
     * This version of quickSort is only good in the average case,
     * whenever the input size is either close to being sorted, or
     * close to being sorted in reverse order, and the input size
     * is large, a stack overflow error will occur. This is because
     * the pivot will be consistently either the biggest or smallest
     * item. This means there is O(n) worst case space complexity, due to
     * O(n) stack frames. For large input sizes, this leads to stack
     * overflow errors.
     *
     * In the average case there will be only O(lg n) stack frames,
     * hence no need to worry.
     */
    
    /* The main function that implements QuickSort() 
     * arr[] --> Array to be sorted
     * low  --> Starting index
     * high  --> Ending index 
     * */

    private void quickSort(ArrayList<Integer> arr, int start, int end) 
    {
		if(start<end) {
		/*Put the pivot in its current position , everything to its left is smaller 
		/everything to its right is larger*/
		int pivotIndex = randomizedPartition(arr,start,end);
		//quickSort the left sub array
		quickSort(arr , start , pivotIndex - 1);
		//quickSort the right sub array
		quickSort(arr , pivotIndex + 1 , end);
		}
	}
    
    /* A utility function to print array of size n */
	private void swap(ArrayList<Integer> array , int i, int j) {
		Collections.swap(array, i, j);
	}
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}
} 