package model;

public class HeapSort extends Sort {
	
	//private ArrayList<Pair<Integer,Long>> heapNTime = new ArrayList<Pair<Integer,Long>>(20);
	private int[] a;
	private int[] b;
	private int currentArray;
	
	public HeapSort(int[] arr) {
		//a = buildHeap(arr);
		buildHeap(arr);
		b = a.clone();
		currentArray = 1;
	}
	
	private void buildHeap(int[] arr) {
		a = arr.clone();
		int n = a.length; 
		
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(a, n, i); 
	}
  
    /* To heapify a subtree rooted with node i which is 
     * an index in arr[]. n is size of heap 
	 * */
    private void heapify(int arr[], int n, int i)
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
        // else is the stopping condition of the recursion
    } 
  
	public void sort() 
    { 
        if(currentArray == 1) {
			//keep a copy of the heapified array
        	b = a.clone();
        	//do the sorting
        	sortThis(a);
        	//switch currentArray
	        currentArray = ~currentArray;
        }else {
        	//keep a copy of the heapified array
        	a = b.clone();
        	//do the sorting
        	sortThis(b);
        	//switch currentArray
	        currentArray = ~currentArray;
        }
    }
	
	private void sortThis(int[] arr) {
		int n = arr.length; 
  	    // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
	}

	/* A utility function to print the sorted array */
    public void printArray() 
    { 
        if(currentArray == 1) {
	    	int n = b.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(b[i]+"\t");
	    }else {
        	int n = a.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(a[i]+"\t");
	    }
        System.out.println();
    }
    
    /* A utility function to print the heap array */
    public void printHeap() 
    { 
        if(currentArray == 1) {
	    	int n = a.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(a[i]+"\t");
	    }else {
        	int n = b.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(b[i]+"\t");
	    }
        System.out.println();
    }

    public int[] getA(){
        return a;
    }
}
