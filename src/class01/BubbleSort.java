package class01;

import java.util.Arrays;

//对数器

public class BubbleSort {
	private static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	private static void swap(int i, int j) {
		int temp;
		temp = i;
		i = j;
		j = temp;
	}

	// 生成随机数组
	private static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	private static int[] copyArray(int[] arr) {
		if (arr == null)
			return null;
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		return arr1;
	}

	// 比较器
	private static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// 判断排序后数组是否相同
	private static boolean isEqual(int[] arr, int[] arr1) {
		if ((arr != null && arr1 == null) || (arr == null && arr1 != null))
			return false;
		if (arr == null && arr1 == null)
			return true;
		if (arr.length != arr1.length)
			return false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr1[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int TestTime = 500;
		int maxValue = 50;
		int maxSize = 10;
		boolean isOk = true;
		for (int i = 0; i < TestTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int[] arr1 = copyArray(arr);
			bubbleSort(arr);
			comparator(arr1);
			isOk = isEqual(arr, arr1);
			if (!isOk)
				break;
		}
		System.out.println(isOk ? "对数器成功" : "垃圾排序");

	}
}
