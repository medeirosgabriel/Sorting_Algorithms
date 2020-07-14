package algorithms;

import java.util.Arrays;

public class InPlaceMergeSort {

	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		mergeSort(array3, 0, array3.length - 1);
		System.out.println(Arrays.toString(array3));
	}
	
	public static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end)/2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);
			merge(array, start, middle, end);
		}
	}

	private static void merge(int[] array, int start, int middle, int end) {
		int left = start;
		int right = middle + 1;
		while (left <= middle && right <= end) { 
			if (array[left] <= array[right]) {
				left++;
			}else {
				int index = right;
				int value = array[right];
				while (index > left) {
					array[index] = array[index - 1];
					index --;
				}
				array[left] = value;
				left ++; middle ++; right ++;
			}
		}
	}
}
