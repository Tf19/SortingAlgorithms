package sortingProcess;

public abstract class SortingProcess {

	protected NumberChain numbers;
	protected float sortingTime;
	
	public SortingProcess(NumberChain numbers) {
		this.numbers = numbers;
	}
	
	public abstract void sort();
	
	public float getSortingTime() {
		return sortingTime;
	}
	
	protected boolean check() {
		int c = 0;
		for (int i = 1; i < numbers.getLength(); i++) {
			if(numbers.get(i) < numbers.get(c)) return false;
			c++;
		}
		return true;
	}
}
