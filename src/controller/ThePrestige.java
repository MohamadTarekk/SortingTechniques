package controller;

//import view.*;
import model.*;

public class ThePrestige {

	public static void main(String[] args) {
		
		// testing heap sort
		/*
		int[] x = {1,2,3,5,4,6,8,-52,52,4516,622,74,12,65};
		HeapSort myHeap = new HeapSort(x);
		myHeap.sort();
		myHeap.printArray();
		myHeap.printHeap();
		myHeap.sort();
		myHeap.printArray();
		myHeap.printHeap();
		*/
		
		// testing insertion sort
		/*
		int[] y = {2,20,4,3,30};
        InsertionSort list = new InsertionSort(y); 
        list.push(5); 
        list.push(20); 
        list.push(4); 
        list.push(3); 
        list.push(30); 
        System.out.println("Linked List before Sorting.."); 
        list.printlist(list.getHead()); 
        list.sort(list.getHead()); 
        System.out.println("\nLinkedList After sorting"); 
        list.printlist(list.getHead()); 
		*/
		
        // testing selection sort
    	/*
    	int arr[] = {64,25,12,22,11}; 
        SelectionSort ob = new SelectionSort(arr); 
        ob.sort(); 
        System.out.println("Sorted array"); 
        ob.printArray(); 
        */
		
        // testing quick sort
        int[] q = {10, 7, 8, 9, 1, 5};
        QuickSort quickSort = new QuickSort(q); 
        quickSort.sort();
        System.out.println("sorted array"); 
        quickSort.printArray();
	}
}
