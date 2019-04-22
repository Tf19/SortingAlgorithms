package sortingProcess;

public class MinsortPro extends SortingProcess {
	
	public static final String COMPLEXITY = "O(n^2)";

	public MinsortPro(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < numbers.getLength()-1; i++) {
			int minPos = i;
			
			for (int j = i+1; j < numbers.getLength(); j++) {
				if(numbers.get(j) < numbers.get(minPos)) minPos = j;
			}
			
			if(numbers.get(minPos) < numbers.get(i)) {
				int temp = numbers.get(minPos);
				numbers.set(minPos, numbers.get(i));
				numbers.set(i, temp);
			}
		}
		sortingTime = System.nanoTime() - startTime;
	}

}