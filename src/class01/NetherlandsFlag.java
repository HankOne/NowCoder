package class01;

public class NetherlandsFlag {

	private static int[] partition(int[] arr, int l, int r, int num) {

		int less = l - 1;
		int more = r + 1;
		int cur = l;
		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);
			} else {// ==num
				cur++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,5,3,9,1,1,6,4};
		int[] is = partition(arr, 0, 7, 5);
		System.out.println(is[0]+"-----"+is[1]);
	}

}
