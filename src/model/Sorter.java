package model;

import java.util.ArrayList;

public class Sorter {
	private ArrayGenerator generator;
	public static ArrayList<Integer> nList = new ArrayList<Integer>(10);
	public static ArrayList<Long> timeList = new ArrayList<Long>(10);
	BubbleSort bubbleSort;
	InsertionSort insertionSort;
	SelectionSort selectionSort;
	HeapSort heapSort;
	QuickSort quickSort;
	MergeSort mergeSort;
	
	
	
	public Sorter(int numberOfSamples) {
		generator = new ArrayGenerator(numberOfSamples);
		/*bubbleSort = new BubbleSort(this.generator.getToBeSorted());
		insertionSort = new InsertionSort(this.generator.getToBeSorted());
		selectionSort = new SelectionSort(this.generator.getToBeSorted());
		heapSort = new HeapSort(this.generator.getToBeSorted());
		quickSort = new QuickSort(this.generator.getToBeSorted());
		mergeSort = new MergeSort(this.generator.getToBeSorted());*/
	}
	
	/*public void Bubblesort() {		
		long time;
		bubbleSort = new BubbleSort(generator.getToBeSorted());
		time = bubbleSort.sort();
		
		bubbleSort = new BubbleSort(generator.getExtraArr1());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr1().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr2());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr2().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr3());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr3().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr4());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr4().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr5());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr5().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr6());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr6().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr7());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr7().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr8());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr8().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getExtraArr9());
		time = bubbleSort.sort();
		nList.add(generator.getExtraArr9().length);
		timeList.add(time);
		
		bubbleSort = new BubbleSort(generator.getToBeSorted());
		time = bubbleSort.sort();
		nList.add(generator.getToBeSorted().length);
		timeList.add(time);
		
	}*/

	public static ArrayList<Integer> getnList() {
		return nList;
	}

	public static ArrayList<Long> getTimeList() {
		return timeList;
	}
	
	
	
	

}
