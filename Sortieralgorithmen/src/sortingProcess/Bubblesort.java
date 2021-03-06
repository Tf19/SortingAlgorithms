package sortingProcess;

public class Bubblesort extends SortingProcess {
	
	public static final String COMPLEXITY = "O(n^2)";

	public Bubblesort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();

		for(int i = 1; i < numbers.getLength(); i++) {
			for(int j = 0; j < numbers.getLength()-i; j++) {
				if(numbers.get(j) > numbers.get(j+1)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(j+1));
					numbers.set(j+1, temp);
				}
			}
		}
		System.out.println(check());
		sortingTime = System.nanoTime() - startTime;
	}

}