package ba.bitcamp.homeworkWeekend6.task06;

public class Task06 {

	public static void main(String[] args) {
		int[][] matrix = new int[6][2];

		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Inputs the values in the matrix
	 * 
	 * @param matrix
	 *            - Matrix in which user want to input values.
	 */
	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	/**
	 * Inputs the values in the matrix from inputed row and column and from
	 * inputed number value.
	 * 
	 * @param matrix
	 *            - Matrix in which user want to input values.
	 * @param i
	 *            - Number of row from which input starts.
	 * @param j
	 *            - Number of column from which input starts.
	 * @param number
	 *            - Number from which input starts
	 */
	public static void fillArray(int[][] matrix, int i, int j, int number) {
		// If the method reaches end of matrix it stops.
		if (i == matrix.length || j == matrix[i].length) {
			return;
		}

		// Inputing number value in the elements.
		matrix[i][j] = number;

		// Calling method
		fillArray(matrix, i, j + 1, number + 1);

		// Setting the value of the number.
		number += matrix[0].length;

		// Calling method again.
		fillArray(matrix, i + 1, j, number);

		return;
	}

}
