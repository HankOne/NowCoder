package class01;

public class HeapSort {

	private static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;// ¶Ñ±ß½ç
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	private static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = ((left + 1) < size) && (arr[left + 1] > arr[left]) ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}

	}

	private static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
			heapInsert(arr, index);
		}
	}

	private static void swap(int[] arr, int index, int i) {
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2,5,6,2,3,5,6,9};
		heapSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
