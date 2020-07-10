package algorithms;

import java.util.Arrays;

public class SimpleAlgorithms {

	public static void main(String[] args) {
		int[] array1 = { -23, 1, 0, 5, 65, 65, 232, 43, 76, 53, 70 };
		int[] array2 = { 1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0 };
		int[] array3 = { -1, -5, -32, -324, -2, -3 };
		selectionSort(array2);
		System.out.println(Arrays.toString(array2));
	}

	// SELECTIONSORT

	public static void selectionSort(int[] array) {
		int smaller, j, temp;
		for (int i = 0; i < array.length; i++) {
			smaller = i;
			for (j = i; j < array.length; j++) {
				if (array[j] < array[smaller]) {
					smaller = j;
				}
			}
			temp = array[i];
			array[i] = array[smaller];
			array[smaller] = temp;
		}
	}

	// SELECTIONSORT RECURSIVO

	public static void selectionSortRecursivo(int[] array, int index) {
		if (index != array.length - 1) {
			int smaller = selectionSmaller(array, index);
			int temp = array[index];
			array[index] = array[smaller];
			array[smaller] = temp;
			selectionSortRecursivo(array, index + 1);
		}
	}

	public static int selectionSmaller(int[] array, int index) {
		if (index == array.length - 1) {
			return index;
		} else {
			int smaller = selectionSmaller(array, index + 1);
			return (array[index] < array[smaller]) ? index : smaller;
		}
	}

	// INSERTIONSORT

	public static void insertionSort(int[] array) {
		int n, j;
		for (int i = 1; i < array.length; i++) {
			n = array[i];
			j = i - 1;
			while (j >= 0 && n < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = n;
		}
	}

	// INSERTIONSORT RECURSIVO

	public static void insertionSortRecursivo(int[] array, int index) {
		if (index != array.length - 1) {
			int n = array[index];
			int j = index - 1;
			while (j >= 0 && n < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = n;
			insertionSortRecursivo(array, index + 1);
		}
	}

	// SHELLSORT

	public static void shellSort(int[] array) {
		int h = array.length - 1, i, j, n;
		while (h > 0) {
			for (i = h; i < array.length; i++) {
				n = array[i];
				j = i;
				while (j >= h && n < array[j - h]) {
					array[j] = array[j - h];
					j -= h;
				}
				array[j] = n;
			}
			h /= 2;
		}
	}

	// BUBBLESORT COM WHILE

	public static void bubbleSortW(int[] array) {
		boolean contin = true;
		int end = array.length - 1, temp;
		while (contin) {
			contin = false;
			for (int i = 0; i < end; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					contin = true;
				}
			}
			end--;
		}
	}

	// BUBBLESORT COM FOR

	public static void bubbleSortF(int[] array) {
		int j, temp;
		for (int i = 0; i < array.length; i++) {
			for (j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// BUBBLESORT RECURSIVO

	public static void bubbleSortRecursivo(int[] array, int index, int f) {
		if (f != 0) {
			if (index == f) {
				bubbleSortRecursivo(array, 0, f - 1);
			} else {
				if (array[index] > array[index + 1]) {
					int temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
				}
				bubbleSortRecursivo(array, index + 1, f);
			}
		}
	}
}
