package sortingProcess;

public class Quicksort extends SortingProcess {
	
	public static final String COMPLEXITY = "O(n*log(n))";

	public Quicksort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();
		quicksort(0, numbers.getLength()-1);
		sortingTime = System.nanoTime() - startTime;
		System.out.println("Erfolg bei Quicksort: " + check());
	}

	/**
	 * rekursiv!
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 */
	private void quicksort(int lowerLimit, int upperLimit) {
		if (lowerLimit < upperLimit) {
			int pivot = numbers.get((lowerLimit + upperLimit)/2);
//			int pivot = numbers.get(lowerLimit);
//			System.out.println("Pivot: " + pivot);
			int i = lowerLimit;
			int j = upperLimit;
			
			while(i <= j ) {
				while(numbers.get(i) < pivot) i++;
				while(numbers.get(j) > pivot) j--;
				if(i <= j) {
					int temp = numbers.get(i);
					numbers.set(i, numbers.get(j));
					numbers.set(j, temp);
					i++;
					j--;
				}
			}
			if(j > lowerLimit) quicksort(lowerLimit, j);
			if(i < upperLimit) quicksort(i, upperLimit);
		}
	}
}
