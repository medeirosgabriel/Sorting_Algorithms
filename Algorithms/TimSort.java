package algorithms;

import java.util.Arrays;

public class TimSort {
	
	static int STEP = 32;

	public static void main(String[] args) {
		int[] array1 = {-23, 1, 0, 5, 65, 65, 232, 43, 76, 53, 70, 105, -1, -5, -32, -324, -2, -3, 
						98, 85, 65, 21, 12, 123, 65, 1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array2 = {1251, 32, 2345, 1, 2, 4, 4, 4, 65, 43, 0};
		int[] array3 = {-1, -5, -32, -324, -2, -3};
		timSort(array1);
		System.out.println(Arrays.toString(array1));
		
	}
	
	public static void timSort(int[] array) { 
		
		int n = array.length;
		
		for (int i = 0; i < n; i += STEP) { 
            insertionSort(array, i, Math.min((i + 31), (n - 1))); 
        } 

        for (int size = STEP; size < n; size = 2 * size) { 
            for (int left = 0; left < n; left += 2 * size) { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (n - 1)); 
                merge(array, left, mid, right); 
            } 
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
