package controller;

import model.BubbleSort;
import model.HeapSort;
import model.MergeSort;
import model.QuickSort;

public class Test {

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
    	
    	ArrayGenerator generator = new ArrayGenerator(20);
    	generator.printArray();
    	System.out.println();
    	BubbleSort bs = new BubbleSort(generator.getToBeSorted());
    	bs.sort();
    	/*SelectionSort ss = new SelectionSort(ArrayGenerator.toBeSorted);
    	ss.sort();
    	System.out.println();
    	ss.printArray();*/
    	/*InsertionSort is = new InsertionSort(ArrayGenerator.toBeSorted);
    	is.sort();
    	System.out.println();
    	is.printArray();*/
    	MergeSort ms = new MergeSort(generator.getToBeSorted());
	    long start = System.nanoTime();
    	ms.sort();
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Time taken by merge sort =  " + time);

    	/*System.out.println();
    	ms.printArray();
    	*/
    	QuickSort qs = new QuickSort(generator.getToBeSorted());
	    start = System.nanoTime();
    	qs.sort();
		end = System.nanoTime();
		time = end - start;
		System.out.println("Time taken by quicksort sort =  " + time);


 
    	/*for(Pair<Integer, Long> p : InsertionSort.insertionNTime)
    		System.out.println(p);*/
    	
    	HeapSort hs = new HeapSort(generator.getToBeSorted());
	    start = System.nanoTime();
    	hs.sort();
    	end = System.nanoTime();
		time = end - start;
		System.out.println("Time taken by heap sort =  " + time);


    	
    }
}
