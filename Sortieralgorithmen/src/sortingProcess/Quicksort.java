package sortingProcess;

public class Quicksort extends SortingProcess {

	public Quicksort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		int zeile = 0;
		for (int i = 0; i < numbers.getLength(); i++) {
			System.out.print(numbers.get(i) + "\t");
			zeile++;
			if (zeile == 10) {
				zeile = 0;
				System.out.println();
			}
		}
		System.out.println();
		zeile = 0;

		quicksort(0, numbers.getLength() - 1);

//		int zeile = 0;
		for (int i = 0; i < numbers.getLength(); i++) {
			System.out.print(numbers.get(i) + "\t");
			zeile++;
			if (zeile == 10) {
				zeile = 0;
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Erfolg: " + check());
	}

	/**
	 * rekursiv!
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 */
	private void quicksort(int lowerLimit, int upperLimit) {
		if (lowerLimit < upperLimit) {
			int[] dividingResult = divide(lowerLimit, upperLimit);
			quicksort(lowerLimit, dividingResult[1]);
			quicksort(dividingResult[0], upperLimit);
		}
	}

	private int[] divide(int lowerLimit, int upperLimit) {
		int i = lowerLimit;
		int j = upperLimit;
		int pivot = numbers.get(upperLimit);

		while (i <= j) {
			while (i < upperLimit - 1 && numbers.get(i) < pivot)
				i++;
			while (j > lowerLimit && numbers.get(j) > pivot)
				j--;
			if (i <= j) {
				int temp = numbers.get(i);
				numbers.set(i, numbers.get(j));
				numbers.set(j, temp);
				i++;
				j--;
			}
		}

		if (numbers.get(i) > pivot) {
			int temp = pivot;
			pivot = numbers.get(i);
			numbers.set(i, temp);
		}
		int a[] = {i,j};
		return a;
	}
}
