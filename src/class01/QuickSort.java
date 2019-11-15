package class01;

public class QuickSort {
	// ¾­µä
	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		int cur = l;
		while (cur < more) {
			if (arr[cur] < arr[r]) {
				swap(arr, cur++, ++less);
			} else if (arr[cur] > arr[r]) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
		swap(arr, more, r);
		int[] res = new int[] { less + 1, more };
		return res;
	}

	private static void swap(int[] arr, int cur, int less) {
		int temp = arr[cur];
		arr[cur] = arr[less];
		arr[less] = temp;
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r)), r);
			int[] res = partition(arr, l, r);
			quickSort(arr, l, res[0] - 1);
			quickSort(arr, res[1] + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 32, 6, 2, 3, 3, 5, 89 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
