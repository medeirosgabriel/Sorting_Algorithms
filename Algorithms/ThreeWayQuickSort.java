package algorithms;

import java.util.Arrays;

public class ThreeWayQuickSort {
	
	public static void main(String[] args) {
		int[] array1 = {-23, 1, 0, 5, 65, 65, 232, 43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		threeWayQuickSort(array3, 0, array3.length - 1);
		System.out.println(Arrays.toString(array3));
	}

	public static void threeWayQuickSort(int[] array, int start, int f) {
		if (start < f) {
			int p1 = start;
			int p2 = start + 1;
			int p3 = f;
			while (p2 <= p3) {
				if (array[p2] < array[p1]) {
					int temp = array[p1];
					array[p1] = array[p2];
					array[p2] = temp;
					p1++;
					p2++;
				}else if (array[p2] > array[p1]) {
					int temp = array[p3];
					array[p3] = array[p2];
					array[p2] = temp;
					p3--;
				}else{
					p2++;
				}
			}
			threeWayQuickSort(array, start, p1 - 1);
			threeWayQuickSort(array, p2, f);
		}
	}
	
}
