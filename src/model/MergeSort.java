package model;

public class MergeSort {
	private int[] arr;
	
	public MergeSort(int[] arr) {
    	this.arr = arr.clone();
    }
	
	/* Divide and conquer algorithm
	 * Split and Merge
	 * If the array is of odd length the extra element goes to the right subarray
	 */
	
	public void sort(){
		mergeSort(arr, 0, arr.length);
	}
	
	private void mergeSort(int[] arr , int start, int end) {
		if(end - start < 2)
			return;
		
		int middle = (start + end) / 2;
		mergeSort(arr, start , middle);
		mergeSort(arr, middle , end);
		merge(arr, start , middle ,end);
	}
	
	private void merge(int[] arr , int start , int middle , int end) {
		/*If the last element in the left partition is less than or equal the first element in the right partition
		 *This mean that all the elements of the left partition is less than the first element in the right parition
		 *Stick the two arrays together 
		 */
		if(arr[middle-1] <= arr[middle])
			return;
		
		int i = start;
		int j = middle;
		int tempIndex = 0; //Keep track where we are in the temp array
		int[] temp = new int[end-start];
		/*
		 * When i = mid we'll have finished traversing the left array , j = end we'll have finished traversing the right array
		 * so we want to drop out
		 */
		while(i<middle && j<end) {
			temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
			/*
			 * Write the smaller element into the temp array
			 * We use equal to preserve the order of duplicate items
			 */
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
		System.arraycopy(arr, i, arr, start + tempIndex, middle-i);
		System.arraycopy(temp, 0, arr, start, tempIndex);
	}
	
	
    public void printArray()
    {
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+"\t"); 
        System.out.println(); 
    }
	
}
