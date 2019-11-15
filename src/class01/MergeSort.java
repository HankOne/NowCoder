package class01;

public class MergeSort {

	private static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l == r)
			return;

		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int[] help = new int[r - l + 1];
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[l + j] = help[j];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 9, 6, 4, 7, 8 };
		mergeSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
