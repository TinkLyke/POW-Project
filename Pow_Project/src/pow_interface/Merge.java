package pow_interface;


/**
 * This class implements merge sort using the comparable interface.
 * 
 * @author Nicolai Kozel
 * @version 1.0 Build 2016
 */
public class Merge {
	/**
	 * Merge sort using Comparable interface.
	 * 
	 * @param x
	 *            - the input array containing times of jobs that need to be
	 *            sorted.
	 * @param n
	 *            - the size of the input array
	 */
	public static void sortMerge(Comparable[] x, int n) {
		if (n <= 1) {
			// do nothing
		} else {
			// split into two parts
			Comparable[] first = new Comparable[n / 2];
			Comparable[] second = new Comparable[n - first.length];
			System.arraycopy(x, 0, first, 0, first.length);
			System.arraycopy(x, first.length, second, 0, second.length);

			// recurse each half
			sortMerge(first, first.length);
			sortMerge(second, second.length);

			// merge both halves together
			merge(first, second, x);
		}
	}

	private static void merge(Comparable[] first, Comparable[] second, Comparable[] x) {
		// TODO Auto-generated method stub
		int iFirst = 0, iSecond = 0, iMerged = 0;
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				x[iMerged] = first[iFirst];
				iFirst++;
			} else {
				x[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		System.arraycopy(first, iFirst, x, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, x, iMerged, second.length - iSecond);
	}

	/**
	 * 
	 * @param x
	 *            -The input array containing jobs that need to be checked if
	 *            they are sorted by time.
	 * @return A boolean value of true if the input array x is sorted
	 */
	public static boolean isSorted(Comparable[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			if (x[i].compareTo(x[i + 1]) > 0) {
				return false; // It is proven that the array is not sorted.
			}
		}
		return true; // If this part has been reached, the array must be sorted.
	}
}
