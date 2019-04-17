package sortingProcess;

public class Minsort extends SortingProcess {
	
	public Minsort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		System.out.println("Starte Sortieren ...");
		long startTime = System.nanoTime();

		for (int i = 0; i < numbers.getLength()-1; i++) {
			for (int j = i+1; j < numbers.getLength(); j++) {
				if(numbers.get(j) < numbers.get(i)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(i));
					numbers.set(i, temp);
				}
			}
		}
		sortingTime = System.nanoTime() - startTime;
		System.out.println("Erfolg: " + check());
		System.out.println();
	}
}