package sortingProcess;

/**
 * Vorteil: ultraschnell
 * Nachteil: keine negativen Zahlen möglich (zumindest nicht ohne Weiteres)
 * Bedingung: möglicher Zahlenraum muss bekannt sein
 * besonders schnell, wenn wenige Zahlen sehr oft vorkommen
 * @author paulb
 *
 */
public class Bossisort extends SortingProcess {
	
	public static final String COMPLEXITY = "O(log(n))";
	private int[] numbersCount = new int[NumberChain.MAX_NUMBER+1];

	public Bossisort(NumberChain numbers) {
		super(numbers);
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();
		for(int i = 0; i < numbers.getLength(); i++) numbersCount[numbers.get(i)] ++;

		
		int j = 0;
		for(int i = 0; i < numbersCount.length; i++) {
			if(numbersCount[i] == 0) continue;
			while(numbersCount[i] > 0) {
				numbers.set(j, i);
				numbersCount[i]--;
				j++;
			}
		}
		
		
		sortingTime = System.nanoTime() - startTime;
//		System.out.println("Erfolg: " + check());
	}

}
