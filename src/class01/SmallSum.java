package class01;

public class SmallSum {

	private static int smallSum(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int mergeSort(int[] arr, int l, int r) {
		if (l == r)
			return 0;

		int mid = (l + r) / 2;
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);

	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid + 1;
		int[] help = new int[r - l + 1];
		int i = 0;
		int res = 0;
		while (p1 <= mid && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
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
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 4, 2, 5 };
		int res = smallSum(arr);
		System.out.println("小数和为：" + res);
	}

}
