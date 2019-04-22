package sortingProcess;

public class NumberChain {
	
	public static final int MIN_NUMBER = 0;
	public static final int MAX_NUMBER = 1000;
	
	private static final int MAX_NUMBER_CHAIN_LENGTH = 999999;
	private static char[] allowedCharacters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-'};
	private static char[] allowedNumbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	private int[] numbers;
	private int length;

	public NumberChain(String string) {
		string = string + "-";
		numbers = parse(string);
		if(numbers[1] == -1) numbers = getRandomNumberChain(numbers[0]);
	}
	
	public int getLength() {
		return length;
	}
	
	public int get(int i) {
		return numbers[i];
	}
	
	public void set(int i, int number) {
		numbers[i] = number;
	}

	private boolean checkForWrongCharacters(String string) {
		for (int i = 0; i < string.length(); i++) {
			boolean allowed = false;
			for (int j = 0; j < allowedCharacters.length; j++) {
				if (string.charAt(i) == allowedCharacters[j]) {
					allowed = true;
					break;
				}
			}
			if (!allowed)
				return false;
		}
		return true;
	}

	private int[] parse(String string) {
		int lastSeperator = -1;
		String newNumber = "";
		int[] arrayToBeReturned = new int[MAX_NUMBER_CHAIN_LENGTH];
		int lastWrittenPosition = -1;
		
		
		for (int i = 0; i < string.length(); i++) {
			boolean temp = false;
			for (int j = 0; j < allowedNumbers.length; j++) {
				if (string.charAt(i) == allowedNumbers[j]) {
					temp = true;
				}
			}
			
			if(!temp) {
				for (int k = lastSeperator+1; k < i; k++) {
					newNumber = newNumber + string.charAt(k);
				}
				int tempNumber = Integer.parseInt(newNumber);
				
				arrayToBeReturned[lastWrittenPosition+1] = tempNumber;
				lastWrittenPosition++;
				newNumber = "";
				lastSeperator = i;
			}
		}
		arrayToBeReturned[lastWrittenPosition+1] = -1; // markiere Ende
		this.length = lastWrittenPosition;
		return arrayToBeReturned;
	}
	
	private int[] getRandomNumberChain(int count) {
		int[] arrayToBeReturned = new int[MAX_NUMBER_CHAIN_LENGTH];
		if(count > MAX_NUMBER_CHAIN_LENGTH) count = MAX_NUMBER_CHAIN_LENGTH;		
		
		for (int i = 0; i < count; i++) {
			int numberToBeWritten;
			do numberToBeWritten = (int) Math.round(Math.random()*1000);
			while(numberToBeWritten < MIN_NUMBER || numberToBeWritten > MAX_NUMBER);
			arrayToBeReturned[i] = numberToBeWritten;
			//System.out.println((int)Math.round(Math.random()*1000));
		}
		this.length = count;
		return arrayToBeReturned;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < getLength(); i++) {
			s += get(i) + " ";
			if(i%25 == 0) s += "\n";
		}
		return s;
	}
}
