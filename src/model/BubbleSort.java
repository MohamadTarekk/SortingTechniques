package model;

public class BubbleSort {
	private int[] arr;
	
	public BubbleSort(int[] arr) {
    	this.arr = arr.clone();
    }
	
	public void sort() {
		int n = arr.length;
		boolean isSwapped;
		for(int i = 0 ; i < n - 1 ; i++) {
			isSwapped = false;
			for(int j = 0 ; j < n - i - 1 ; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j , j+1);
					isSwapped = true;
				}
			}
            //check if any swapping occurred in last iteration
            //if yes then break the loop, array is sorted at this point
			if(!isSwapped)
				break;
		}
	}
	
	
	private void swap(int[] array , int i, int j) {
		if(i == j)
			return;
		int swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}
	
    public void printArray()
    {
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+"\t"); 
        System.out.println(); 
    }
}
