package algorithms;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] array1 = { -23, 1, 0, 5, 65, 65, 232, 43, 76, 53, 70, 105, -1, -5, -32, -324, -2, -3, 98, 85, 65, 21, 12,
				123, 65, 1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0 };
		int[] array2 = { 1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0 };
		int[] array3 = { -1, -5, -32, -324, -2, -3 };
		shellSort(array3);
		System.out.println(Arrays.toString(array3));
	}

	private static void shellSort(int[] array) {
		int n = array.length;
		for (int gap = n/2; gap > 0; gap/=2) {
			for (int i = gap; i < n; i++) {
				int value = array[i];
				int j = i;
				while (j >= gap && value < array[j - gap]) {
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = value;
			}
		}
		
	}
}
