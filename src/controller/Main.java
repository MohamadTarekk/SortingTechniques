package controller;

import java.util.ArrayList;

import model.ArrayGenerator;

public class Main {

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
		//int[] q = {10, 7, 8, 9, 1};
		  //  int[] m = {1 , 2 , 3, 4, 5};
		//QuickSort quickSort = new QuickSort(q); 
		   // long start = System.nanoTime();
		   // quickSort.sort();
		   // long end = System.nanoTime();
		   // long timeInNano = end - start;
		   // System.out.println("sorted array"); 
		//quickSort.printArray();
		//System.out.println("Time taken to sort the array = " + timeInNano);
		
		/*MergeSort mergeSort2 = new MergeSort(q);
		mergeSort2.sort();
		
		
		SelectionSort selectionSort = new SelectionSort(q);*/
		   // selectionSort.sort();
		//selectionSort.printArray();
		
		    
		   /* MergeSort mergeSort = new MergeSort(q);
		long start = System.nanoTime();
		mergeSort.sort();
		long end = System.nanoTime();
		System.out.println("Time taken to sort the array = " + (end-start));
		mergeSort.printArray();
		System.out.println("------");
		start = System.nanoTime();
		selectionSort.sort();
		end = System.nanoTime();
		System.out.println("Time taken to sort the array = " + (end-start));
		selectionSort.printArray();  */
		
		/*BubbleSort bubbleSort = new BubbleSort(m);
		start = System.nanoTime();
		bubbleSort.sort();
		end = System.nanoTime();
		System.out.println("Time taken to sort the array = " + (end-start));
		bubbleSort.printArray();*/
		    
	    ArrayGenerator generator = new ArrayGenerator(10000);
	    int n = generator.getToBeSorted().length;
	    int[] tempArray;
	    int step = generator.getStep();
	    generator.printArray();
	    System.out.println();
	   /* ArrayList<Integer> arrayList = new ArrayList<Integer>();
	    for(int i = 0 ; i < n ; i+=step) {
	    	for(int j = 0 ; j < i ; j++)
	    		arrayList.add(tempArray[i]);
	    	printArray(arrayList.toArray());
	    }
	    	printArray(arrayList.toArray());*/
	   for(int i = 0 ; i < n/2 ; i++) {
	    	tempArray = new int[step*(i+1)];
	    	for(int j = 0 ; j < tempArray.length ; j++)
				tempArray[j] = (int)(n*Math.random());
	    	printArray(tempArray);

	    }
	    	    
	    
	   /*System.out.println(generator.getToBeSorted().length);
	    for(int i = 0 ; i < generator.getToBeSorted().length;i++)
	        System.out.println(generator.getToBeSorted()[i]);
	        */
	    
	   // for(int i = 0 ; i < generator.getToBeSorted().length ; i++) {
    //tempArray = new int[generator.getStep()*(i)];
    //System.arraycopy(generator.getToBeSorted(), 0, tempArray, 0, generator.getStep()*(i));
    /*tempArray = Arrays.copyOf(generator.getToBeSorted(), generator.getStep());
        for(int j = 0 ; j < tempArray.length ; j++)
            System.out.print(tempArray[j]);
  //  }
        System.out.println();
        System.out.println(tempArray.length);*/

	}
	
	public static void printArray(int[] arr) {
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+"\t"); 
        System.out.println(); 
	}
}
