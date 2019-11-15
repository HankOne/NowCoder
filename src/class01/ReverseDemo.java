package class01;

public class ReverseDemo {

	static int count = 0;

	private static void reverse(int[] arr) {
		mergerSort(arr, 0, arr.length - 1);
	}

	private static void mergerSort(int[] arr, int l, int r) {
		if (l == r)
			return;
		int mid = (l + r) / 2;
		mergerSort(arr, l, mid);
		mergerSort(arr, mid + 1, r);
		merge(arr, l, mid, r);

	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid + 1;
		int[] help = new int[r - l + 1];
		int i = 0;
		while (p1 <= mid && p2 <= r) {
			if (arr[p1] > arr[p2])
				count += (mid - p1 + 1);
			// System.out.println(arr[p1]>arr[p2]?(arr[p1]+"---"+arr[p2]):"");
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (int x = 0; x < help.length; x++) {
			arr[l + x] = help[x];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 6,5,4,3,2,1 };
		reverse(arr);
		System.out.println(count);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
