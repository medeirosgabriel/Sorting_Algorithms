package algorithms;

import java.util.Arrays;

public class CocktailSort {

	public static void main(String[] args) {
		int[] array1 = {-23, -1, 0, 5, -65, 65, 232, -43, 76, 53, 70 };
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		cocktailSort(array1);
		System.out.println(Arrays.toString(array1));
	}
	
	public static void cocktailSort(int[] array) {
		int lastIndex = array.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			for (int j = i; j < lastIndex - i; j++ ) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
				if (array[lastIndex - j] < array[lastIndex - j - 1]) {
					swap(array, lastIndex - j, lastIndex - j - 1);
				}
			}
		}
	}
	
	public static void swap(int[] array, int i1, int i2) {
		int aux = array[i1];
		array[i1] = array[i2];
		array[i2] = aux;
	}
}	