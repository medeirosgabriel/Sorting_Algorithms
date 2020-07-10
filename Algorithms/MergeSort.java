package algorithms;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		mergeSort(array1, 0, array1.length - 1);
		System.out.println(Arrays.toString(array1));
	}

	// MERGESORT

	public static void mergeSort(int[] array, int start, int f) {
		if (start < f) {
			int middle = (start + f)/2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, f);
			merge(array, start, middle, f);
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