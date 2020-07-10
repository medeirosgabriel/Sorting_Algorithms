package algorithms;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		extendedCountingSort(array1);
		System.out.println(Arrays.toString(array1));
	}

	// COUNTINGSORT NORMAL - DOESN'T ACCEPT NEGATIVE NUMBERS
	
	public static void countingSort(int[] array) {
		int max = Arrays.stream(array).max().getAsInt();
		int[] count = new int[max + 1];
		int[] output = new int[array.length];
		int i;
		for (i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (i = array.length - 1; i >= 0; i--) {
			output[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}
		for (i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}
	
	// EXTENDED COUNTINGSORT - ACCEPTS NEGATIVE NUMBERS
	
	public static void extendedCountingSort(int[] array) {
		int max = Arrays.stream(array).max().getAsInt();
		int min = Arrays.stream(array).min().getAsInt();
		int[] count = new int[max - min + 1];
		int[] output = new int[array.length];
		int i;
		for (i = 0; i < array.length; i++) {
			count[array[i] - min]++;
		}
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (i = array.length - 1; i >= 0; i--) {
			output[count[array[i] - min] - 1] = array[i];
			count[array[i] - min]--;
		}
		for (i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}
}
