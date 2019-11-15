package class01;

public class SelectionSort {

	private static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr=new int[]{1,5,3,4,6,8,9};
		selectionSort(arr);
		for(int i:arr){
			System.out.print(i+" ");
		}
	}

}
/*
package p1;


public class Solution {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 0 };
		int i = InversePairs(a);
		System.out.println(i);
	}

	public static int InversePairs(int[] array) {
		int p = sort(array, 0, array.length - 1);
		if (p < 1000000007) {
			return (p);
		} else {
			return (p % 1000000007);
		}

	}

	public static int sort(int[] array, int i, int j) {
		if (j <= i)
			return 0;
		int mid = i + (j - i) >> 1;
		return sort(array, i, mid) + sort(array, mid + 1, j) + merge(array, i, j, mid);
	}

	public static int merge(int[] array, int i, int j, int mid) {
		int p1 = i;
		int p2 = mid + 1;
		int index = 0;
		int[] help = new int[j - i + 1];
		int res = 0;
		while (p1 <= mid && p2 <= j) {
			res += array[p1] > array[p2] ? (mid - p1 + 1) : 0;
			help[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
		}
		while (p1 <= mid) {
			help[index++] = array[p1++];
		}
		while (p2 <= j) {
			help[index++] = array[p2++];
		}
		for (int k = 0; k < help.length; k++) {
			array[k + i] = help[k];
		}
		return res;
	}
}


 */