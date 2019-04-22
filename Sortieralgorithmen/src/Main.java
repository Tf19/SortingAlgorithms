
import java.util.Scanner;

import sortingProcess.Bossisort;
import sortingProcess.Bubblesort;
import sortingProcess.Minsort;
import sortingProcess.MinsortPro;
import sortingProcess.NumberChain;
import sortingProcess.Quicksort;
import sortingProcess.QuicksortConcurrently;
import sortingProcess.SortingProcess;

public class Main {

	public static final int MINSORT = 1;
	public static final int MINSORT_IMPROVED = 2;
	public static final int BUBBLESORT = 3;
	public static final int QUICKSORT = 4;
	public static final int QUICKSORT_CC = 5;
	public static final int BOSSISORT = 6;
	public static final int ALL = 7;
	public static SortingProcess process;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("SORTIERALGORITHMEN (c) Paul Boswank 2019");
		Scanner sc1 = new Scanner(System.in);
		boolean exit = false;
		do {
			System.out.println("Geben Sie die zu sortierenden Zahlen mit einem Minus voneinander getrennt ein.");
			System.out.println("Beispiel: '3-5-6-9-12-23-0-7'");
			System.out.println(
					"Alternativ geben Sie eine Zahl ein, um eine Kette von Zufallszahlen mit eben dieser Länge zu generieren.");
			System.out.print("Eingabe: ");
			
			String enteredNumbers = sc1.nextLine();

			NumberChain nc = new NumberChain(enteredNumbers);

			// _______________________________________
			System.out.println("\nWählen Sie das zu verwendende Sortierverfahren:");
			System.out.println(MINSORT + " - Minsort");
			System.out.println(MINSORT_IMPROVED + " - verbessertes Minsort");
			System.out.println(BUBBLESORT + " - Bubblesort");
			System.out.println(QUICKSORT + " - Quicksort");
			System.out.println(QUICKSORT_CC + " - Quicksort (nebenläufig, " + QuicksortConcurrently.SIZE_THRESHOLD
					+ " Elemente pro Thread)");
			System.out.println(BOSSISORT + " - Bossisort");
			System.out.println(ALL + " - alle nacheinander (bei gleicher Zahlenreihe)");
			System.out.print("Antwort: ");

			String enteredSortingProcess = sc1.nextLine();
			
			if (Integer.parseInt(enteredSortingProcess) == ALL) {
				process = new Minsort(nc);
				process.sort();
				System.out.println("\nBenötigte Zeiten zum Sortieren:\nMinsort:\t\t\t"
						+ process.getSortingTime() / 1000000 + " ms\t" + Minsort.COMPLEXITY);
				process = new MinsortPro(nc);
				process.sort();
				System.out.println(
						"verb. Minsort:\t\t\t" + process.getSortingTime() / 1000000 + " ms\t" + MinsortPro.COMPLEXITY);
				process = new Bubblesort(nc);
				process.sort();
				System.out.println(
						"Bubblesort:\t\t\t" + process.getSortingTime() / 1000000 + " ms\t" + Bubblesort.COMPLEXITY);
				process = new Quicksort(nc);
				process.sort();
				System.out.println(
						"Quicksort:\t\t\t" + process.getSortingTime() / 1000000 + " ms\t" + Quicksort.COMPLEXITY);
				process = new QuicksortConcurrently(nc);
				process.sort();
				System.out.println("Quicksort (nebenläufig):\t" + process.getSortingTime() / 1000000 + " ms\t"
						+ QuicksortConcurrently.COMPLEXITY);
				process = new Bossisort(nc);
				process.sort();
				System.out.println(
						"Bossisort:\t\t\t" + process.getSortingTime() / 1000000 + " ms\t" + Bossisort.COMPLEXITY);
			} else {
				if (Integer.parseInt(enteredSortingProcess) == MINSORT)
					process = new Minsort(nc);
				if (Integer.parseInt(enteredSortingProcess) == MINSORT_IMPROVED)
					process = new MinsortPro(nc);
				if (Integer.parseInt(enteredSortingProcess) == BUBBLESORT)
					process = new Bubblesort(nc);
				if (Integer.parseInt(enteredSortingProcess) == QUICKSORT)
					process = new Quicksort(nc);
				if (Integer.parseInt(enteredSortingProcess) == QUICKSORT_CC)
					process = new QuicksortConcurrently(nc);
				if (Integer.parseInt(enteredSortingProcess) == BOSSISORT)
					process = new Bossisort(nc);
				process.sort();
				System.out.println("Benötigte Zeit zum Sortieren: " + process.getSortingTime() / 1000000 + " ms");
			}
			System.out.println("Nochmal?\nAntwort (j/n): ");
			String again = sc1.nextLine();
			System.out.println("\n\n\n\n");
			if(again.contains("n")) exit = true;
		} while (!exit);
	}

}
