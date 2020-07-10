package algorithms;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String[] args) {
		int[] array1 = {1, 0, 5, 65, 65, 232, 43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		radixSort(array1);
		System.out.println(Arrays.toString(array1));
	}
	
	// DOESN'T ACCEPT NEGATIVE NUMBERS
	
	public static void radixSort(int[] array) {
		int max = Arrays.stream(array).max().getAsInt();
		for (int exp = 1; (max/exp) > 0; exp*=10) {
			sort(array, exp);
		}
	}

	private static void sort(int[] array, int exp) {
		int[] count = new int[10];
		int[] output = new int[array.length];
		int i;
		for (i = 0; i < array.length; i++) {
			count[(array[i]/exp)%10] ++;
		}
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (i = array.length - 1; i >= 0; i--) {
			output[count[(array[i]/exp)%10] - 1] = array[i];
			count[(array[i]/exp)%10] --;
		}
		for (i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}
}
