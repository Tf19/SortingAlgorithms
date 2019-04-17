package sortingProcess;

public class MinsortPro extends SortingProcess {

	public MinsortPro(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		System.out.println("Starte Sortieren ...");
		long startTime = System.nanoTime();
		int minPos = 0;
		
		for (int i = 0; i < numbers.getLength()-1; i++) {
			
			for (int j = i+1; j < numbers.getLength(); j++) {
				if(numbers.get(j) < numbers.get(minPos)) minPos = j;
			}
			
			if(numbers.get(minPos) < numbers.get(i)) {
				int temp = numbers.get(minPos);
				numbers.set(minPos, numbers.get(i));
				numbers.set(i, temp);
			}
		}
		
		System.out.println("Erfolg: " + check());

//		for (int i = 0; i < numbers.getLength()-1; i++) {
//			for (int j = i+1; j < numbers.getLength(); j++) {
//				if(numbers.get(j) < numbers.get(minPos)) minPos = j;
//				if(numbers.get(minPos) < numbers.get(i)) {
//					int temp = numbers.get(j);
//					numbers.set(j, numbers.get(i));
//					numbers.set(i, temp);
//				}
//			}
//		}
		sortingTime = System.nanoTime() - startTime;
		System.out.println();
		
	}

}