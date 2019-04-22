package sortingProcess;

public class Bubblesort extends SortingProcess {
	
	public static final String COMPLEXITY = "O(n^2)";

	public Bubblesort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();
		for (int i = 0; i < numbers.getLength() - 1; i++) {
			for (int j = i+1; j < numbers.getLength(); j++) {
				if (numbers.get(j) < numbers.get(i)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(i));
					numbers.set(i, temp);
				}
			}
		}
		sortingTime = System.nanoTime() - startTime;
	}

}
