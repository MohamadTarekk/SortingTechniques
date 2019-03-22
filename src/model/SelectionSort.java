package model;

public class SelectionSort {

	private int[] arr;
	
	public SelectionSort(int[] arr) {
    	this.arr = arr.clone();
    }
	
	public void sort()
    {
        int n = arr.length;
        
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        {
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            
            // Swap the found minimum element with the first element 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public void printArray()
    {
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+"\t"); 
        System.out.println(); 
    }
}