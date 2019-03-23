package model;

public class ArrayGenerator {
	
	private int numberOfSamples;
	private int step;
	private int[] toBeSorted;
	private int[] extraArr1;
	private int[] extraArr2;
	private int[] extraArr3;
	private int[] extraArr4;
	private int[] extraArr5;
	private int[] extraArr6;
	private int[] extraArr7;
	private int[] extraArr8;
	private int[] extraArr9;

	public ArrayGenerator(int numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
		this.step = Math.round(numberOfSamples / 10);
		toBeSorted = new int[numberOfSamples];
		extraArr1 = new int[step];
		extraArr2 = new int[2*step];
		extraArr3 = new int[3*step];
		extraArr4 = new int[4*step];
		extraArr5 = new int[5*step];
		extraArr6 = new int[6*step];
		extraArr7 = new int[7*step];
		extraArr8= new int[8*step];
		extraArr9 = new int[9*step];
		randomizeArray();
		fillArrays();
	}
	
	
	private void randomizeArray() {
		for(int i = 0 ; i < numberOfSamples ; i++) {
			int random = (int)(Math.random() * numberOfSamples);
			toBeSorted[i] = random;
		}
	}
		
	public void printArray() {
        int n = toBeSorted.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(toBeSorted[i]+"\t"); 
        System.out.println(); 
	}
	
	
	private void fillArrays() {
		for(int i = 0 ; i < step; i++) {
			extraArr1[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 2*step; i++) {
			extraArr2[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 3*step; i++) {
			extraArr3[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 4*step; i++) {
			extraArr4[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 5*step; i++) {
			extraArr5[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 6*step; i++) {
			extraArr6[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 7*step; i++) {
			extraArr7[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 8*step; i++) {
			extraArr8[i] = toBeSorted[i];
		}
		for(int i = 0 ; i < 9*step; i++) {
			extraArr9[i] = toBeSorted[i];
		}
	}

	public int[] getToBeSorted() {
		return toBeSorted;
	}
	
	public int[] getExtraArr1() {
		return extraArr1;
	}


	public int[] getExtraArr3() {
		return extraArr3;
	}


	public int[] getExtraArr4() {
		return extraArr4;
	}


	public int[] getExtraArr5() {
		return extraArr5;
	}


	public int[] getExtraArr6() {
		return extraArr6;
	}


	public int[] getExtraArr7() {
		return extraArr7;
	}


	public int[] getExtraArr8() {
		return extraArr8;
	}


	public int[] getExtraArr9() {
		return extraArr9;
	}


	public int[] getExtraArr2() {
		return extraArr2;
	}


	public int getStep() {
		return step;
	}
	
	public int getNumberOfSamples() {
		return numberOfSamples;
	}
	

}
