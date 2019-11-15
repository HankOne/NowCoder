package class01;

public class TestDemo1 {
	public static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
			}
		}
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}

	
	 // 以最后一个元素为比较对象 左边是小于它的元素 右边是大于它的元素
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		int cur = l;
		while (cur < more) {
			if (arr[cur] < arr[r]) {
				swap(arr, cur++, ++less);
			} else if (arr[cur] > arr[r]) {
				swap(arr, --more, cur);
			} else {
				cur++;
			}
		}
		swap(arr, more, r);// 将数组的最后一个元素放到它应在的位置
		return new int[] { less + 1, more };
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			//随机快速排序
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			// 经典快速排序
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 6, 3, 4, 8, 9 };
		// bubbleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);
		// mergeSort(arr, 0, 6);
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
