package class_03;

public class Code_06_PrintMatrixSpiralOrder {

	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] m, int a, int b, int c, int d) {
		if (a == c) {
			for (int i = b; i <= d; i++) {
				System.out.print(m[a][i] + " ");
			}
		} else if (b == d) {
			for (int i = a; i <= c; i++) {
				System.out.print(m[i][b] + " ");
			}
		} else {
			int curR = a;
			int curC = b;
			while (curC != d) {
				System.out.print(m[a][curC] + " ");
				curC++;
			}
			while (curR != c) {
				System.out.print(m[curR][d] + " ");
				curR++;
			}
			while (curC != b) {
				System.out.print(m[c][curC] + " ");
				curC--;
			}
			while (curR != a) {
				System.out.print(m[curR][b] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
