

import java.util.Scanner;

import sortingProcess.Minsort;
import sortingProcess.MinsortPro;
import sortingProcess.NumberChain;
import sortingProcess.Quicksort;
import sortingProcess.SortingProcess;

public class Main {
	
	public static final int MINSORT = 1;
	public static final int MINSORT_IMPROVED = 2;
	public static final int BUBBLESORT = 3;
	public static final int QUICKSORT = 4;
	public static SortingProcess process;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
				System.out.println("SORTIERALGORITHMEN (c) Paul Boswank 2019");
		System.out.println(
				"Geben Sie die zu sortierenden Zahlen mit einem Minus voneinander getrennt ein.");
		System.out.println("Beispiel: '3-5-6-9-12-23-0-7'");
		System.out.println(
				"Alternativ geben Sie eine Zahl ein, um eine Kette von Zufallszahlen mit eben dieser Länge zu generieren.");
		System.out.print("Eingabe: ");
		Scanner sc1 = new Scanner(System.in);
		String enteredNumbers = sc1.nextLine();

		NumberChain nc = new NumberChain(enteredNumbers);

		// _______________________________________
		System.out.println("\n\nWählen Sie das zu verwendende Sortierverfahren:");
		System.out.println(MINSORT + " - Minsort");
		System.out.println(MINSORT_IMPROVED + " - verbessertes Minsort");
		System.out.println(BUBBLESORT + " - Bubblesort");
		System.out.println(QUICKSORT + " - Quicksort");
		System.out.print("Antwort: ");
		
		String enteredSortingProcess = sc1.nextLine();
		// Schließen des Scanners (nicht nötig, aber empfohlen)
		sc1.close();
		if(Integer.parseInt(enteredSortingProcess) == MINSORT) process = new Minsort(nc);
		if(Integer.parseInt(enteredSortingProcess) == MINSORT_IMPROVED) process = new MinsortPro(nc);
		if(Integer.parseInt(enteredSortingProcess) == QUICKSORT) process = new Quicksort(nc);
		process.sort();
		System.out.println("Benötigte Zeit zum Sortieren: " + process.getSortingTime()/1000000 + " ms");
	}

}
