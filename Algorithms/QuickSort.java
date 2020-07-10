package algorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		quickSort(array1, 0, array1.length - 1);
		System.out.println(Arrays.toString(array1));
	}
	
	public static void quickSort(int[] array, int start, int f) {
		if (start < f) {
			int pivotPosition = partition(array, start, f);
			quickSort(array, start, pivotPosition - 1);
			quickSort(array, pivotPosition + 1, f);
		}
	}

	private static int partition(int[] array, int start, int f) {
		int pivot = array[start], left = start, right = f, temp;
		while (left <= right) {
			if (array[left] <= pivot) {
				left++;
			} else if (array[right] > pivot) {
				right--;
			} else {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		array[start] = array[right];
		array[right] = pivot;
		return right;
	}

}
