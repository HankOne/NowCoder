package class01;

public class InsertionSort {
	
	private static void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++){
			for(int j=i-1;j>=0&&arr[j+1]<arr[j];j--){
				int temp=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr=new int[]{1,5,3,6,4,8,9,10,5,9,2,6,1};
		insertionSort(arr);
		for(int i:arr){
			System.out.print(i+" ");
		}
	}

}
