package sortingProcess;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuicksortConcurrently extends SortingProcess {
	
	public static final String COMPLEXITY = "?";
	public static final int SIZE_THRESHOLD = 100;
	private static final ForkJoinPool THREADPOOL = new ForkJoinPool();

	public QuicksortConcurrently(NumberChain numbers) {
		super(numbers);
	}

	/**
	 * Innere statische Klasse die Fork and Join aus dem Concurrency package
	 * implementiert. Sie macht aus Methodenaufrufen, Taskaufrufe von Threads
	 */
	static class SortTask extends RecursiveAction {
		int lo, hi;
		QuicksortConcurrently qsp;

		/**
		 * Speichere alle wichtigen Parameter für den Task
		 * 
		 * @param lo  untere Intervallgrenze
		 * @param hi  obere Intervallgrenze
		 * @param qsp Referenz auf das zu sortierende Objekt
		 */
		SortTask(int lo, int hi, QuicksortConcurrently qsp) {
			this.lo = lo;
			this.hi = hi;
			this.qsp = qsp;
		}

		/**
		 * Führe Task in eigenem Thread aus und nutze Instanzvariablen als Parameter um
		 * Aufgabe auszuführen.
		 */
		@Override
		protected void compute() {
			// System.out.println(" Thread ID => " + Thread.currentThread().getId());
			if (hi - lo < SIZE_THRESHOLD) {
				// Sortiere kleine Intervalle seriell
				qsp.sortierenSeriell(lo, hi);
			} else { // Sortiere große Intervalle parallel
				int obergrenzeLinkesIntervall;
				obergrenzeLinkesIntervall = qsp.teilsortieren(lo, hi);
				// der serielle rekursive Aufruf wird ersetzt durch
				// den parallelen Aufruf zweier Threads aus dem Threadpool
				// System.out.println("Parallel: "+
				// lo+","+obergrenzeLinkesIntervall+","+hi);
				invokeAll(new SortTask(lo, obergrenzeLinkesIntervall, qsp),
						new SortTask(obergrenzeLinkesIntervall + 1, hi, qsp));
			}
		}
	}

	/**
	 * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder zurück
	 * 
	 * @param s ein unsortiertes Feld
	 * @return ein sortiertes Feld
	 */
	public void sortieren(int startIndex, int endeIndex) {
		THREADPOOL.invoke(new SortTask(startIndex, endeIndex, this));
	}

	/**
	 * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder zurück
	 * 
	 * @param s ein unsortiertes Feld
	 * @return ein sortiertes Feld
	 */
	public void sortierenSeriell(int startIndex, int endeIndex) {
		if (endeIndex > startIndex) {
			int obergrenzeLinkesIntervall = teilsortieren(startIndex, endeIndex);
			// System.out.println("Seriell: "+
			// startIndex+","+obergrenzeLinkesIntervall+","+endeIndex);
			// Sortiere unteren Bereich
			if (startIndex < obergrenzeLinkesIntervall) {
				sortierenSeriell(startIndex, obergrenzeLinkesIntervall);
			}
			// Sortiere oberen Bereich
			if (obergrenzeLinkesIntervall + 1 < endeIndex) {
				sortierenSeriell(obergrenzeLinkesIntervall + 1, endeIndex);
			}
		}
	}

	public int teilsortieren(int startIndex, int endeIndex) {
		int i = startIndex;
		int j = endeIndex;
		int pivotWert = numbers.get(startIndex + (endeIndex - startIndex) / 2);

		while (i <= j) {
			while (numbers.get(i) < pivotWert) {
				i++;
//				vglZaehler();
			}
			while (numbers.get(j) > pivotWert) {
				j--;
//				vglZaehler();
			}
			if (i <= j) {
				int temp = numbers.get(i);
				numbers.set(i, numbers.get(j));
				numbers.set(j, temp);
				i++;
				j--;
			}
		}
		return i - 1;
	}

	@Override
	public void sort() {
		long startTime = System.nanoTime();
		sortieren(0, numbers.getLength()-1);
		sortingTime = System.nanoTime() - startTime;
	}
}

//public class QuicksortConcurrently extends SortingProcess {
//
//	int workingThreadsCount = 0; // additional threads (not the main thread itself)
//	QuicksortThread[] leftThread = new QuicksortThread[250];
//	QuicksortThread[] rightThread = new QuicksortThread[250];
//
//	public QuicksortConcurrently(NumberChain numbers) {
//		super(numbers);
//	}
//
//	@Override
//	public void sort() {
//		System.out.println("Thread-Anzahl: " + getThreadCount());
//		long startTime = System.nanoTime();
//		new QuicksortThread();
//		sortingTime = System.nanoTime() - startTime;
//		System.out.println("Erfolg: " + check());
//	}
//
//	
//
//	/**
//	 * Gibt eine empfohlene Anzahl an Threads zurück, die gleichzeitig laufen
//	 * sollten
//	 * 
//	 * @return
//	 */
//	private int getThreadCount() {
//		if (numbers.getLength() < 50)
//			return 1;
//		int t = numbers.getLength() / 200;
//		if (t % 2 != 0 || t == 0)
//			t++;
//		if (t > 500)
//			t = 500;
//		return t;
//	}
//
//	private class QuicksortThread extends Thread {
//
//		private final int lowerLimit, upperLimit;
//
//		private QuicksortThread(int lowerLimit, int upperLimit) {
//			workingThreadsCount ++;
//			System.out.println("Starte neuen Thread ...");
//			this.lowerLimit = lowerLimit;
//			this.upperLimit = upperLimit;
//			this.start();
//		}
//		
//		private QuicksortThread() { // only use for starting quicksort
//			this.lowerLimit = 0;
//			this.upperLimit = numbers.getLength()-1;
//			startSorting();
//		}
//
//		@Override
//		public void run() {
//			quicksort(lowerLimit, upperLimit);
//		}
//		
//		private void startSorting() {
//			quicksort(0, numbers.getLength() - 1);
//		}
//		
//		/**
//		 * rekursiv!
//		 * 
//		 * @param lowerLimit
//		 * @param upperLimit
//		 */
//		private void quicksort(int lowerLimit, int upperLimit) {
//			if (lowerLimit < upperLimit) {
//				int pivot = numbers.get((lowerLimit + upperLimit) / 2);
////				System.out.println("Pivot: " + pivot);
//				int low = lowerLimit;
//				int up = upperLimit;
//
//				while (low <= up) {
//					while (numbers.get(low) < pivot)
//						low++;
//					while (numbers.get(up) > pivot)
//						up--;
//					if (low <= up) {
//						int temp = numbers.get(low);
//						numbers.set(low, numbers.get(up));
//						numbers.set(up, temp);
//						low++;
//						up--;
//					}
//				}
//				if (getThreadCount() - workingThreadsCount >= 2) {
//					if (up > lowerLimit) {
//						rightThread[workingThreadsCount / 2] = new QuicksortThread(lowerLimit, up);
//						System.out.println("Starte rechtsseitigen Thread " + (workingThreadsCount / 2));
////						rightThread[workingThreadsCount / 2].start();
//					}
//					if (low < upperLimit) {
//						leftThread[workingThreadsCount / 2] = new QuicksortThread(low, upperLimit);
//						System.out.println("Starte linksseitigen Thread " + (workingThreadsCount / 2));
////						leftThread[workingThreadsCount / 2].start();
//					}
//					
//					try {
//						rightThread[workingThreadsCount / 2-1].join();
//						leftThread[workingThreadsCount / 2-1].join();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					
//					
//					
//				} else {
//					if (up > lowerLimit)
//						quicksort(lowerLimit, up);
//					if (low < upperLimit)
//						quicksort(low, upperLimit);
//				}
//			}
//		}
//	}
//}
