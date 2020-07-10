package algorithms;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		heapSort(array1);
		System.out.println(Arrays.toString(array1));
	}

	// HEAPSORT

	public static void heapSort(int[] array) {
		int i, temp;
		for (i = (array.length - 1) / 2; i >= 0; i--) {
			buildHeap(array, i, array.length - 1);
		}
		for (i = array.length - 1; i >= 1; i--) {
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			buildHeap(array, 0, i - 1);
		}
	}

	private static void buildHeap(int[] array, int i, int f) {
		int pivot = array[i];
		int j = 2 * i + 1;
		while (j <= f) {
			if (j < f) {
				if (array[j] < array[j + 1]) {
					j += 1;
				}
			}
			if (array[j] > pivot) {
				array[i] = array[j];
				i = j;
				j = 2 * i + 1;
			} else {
				break;
			}
		}
		array[i] = pivot;
	}
}
