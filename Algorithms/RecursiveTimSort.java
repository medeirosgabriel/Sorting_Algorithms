package algorithms;

import java.util.Arrays;

public class RecursiveTimSort {
	
	static int STEP = 32;
	
	public static void main(String[] args) {
		int[] array1 = {-23, 1, 0, 5, 65, 65, 232, 43, 76, 53, 70, 105, -1, -5, -32, -324, -2, -3, 
						98, 85, 65, 21, 12, 123, 65, 1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		timSort(array1, 0, array1.length - 1);
		System.out.println(Arrays.toString(array1));
	}
	
	public static void timSort(int[] array, int start, int end) {
		if (start - end > STEP) {
			int mid = (start + end)/2;
			timSort(array, start, mid);
			timSort(array, mid + 1, end);
			merge(array, start, mid, end);
		} else {
			insertionSort(array, start, end);
		}
    }
	
	// Could be any sorting algorithm!!!
	
	public static void insertionSort(int[] array, int start, int end) {
		int n, j;
		for (int i = start; i <= end; i++) {
			n = array[i];
			j = i - 1;
			while (j >= 0 && n < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = n;
		}
	}
	
	private static void merge(int[] array, int start, int middle, int f) {
		int[] aux = new int[f - start + 1];
		int i = 0;
		int p1 = start;
		int p2 = middle + 1;
		while (p1 <= middle && p2 <= f) {
			if (array[p1] <= array[p2]) {
				aux[i++] = array[p1++];
			} else {
				aux[i++] = array[p2++];
			}
		}
		while (p1 <= middle) {
			aux[i++] = array[p1++];
		}
		while (p2 <= f) {
			aux[i++] = array[p2++];
		}
		for (i = start; i <= f; i++) {
			array[i] = aux[i - start];
		}
	}
}
