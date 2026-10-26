
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int count = 1;
        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = n - 1;

        while (count <= n * n) {

            // Left to right
            for (int c = minCol; c <= maxCol; c++) {
                arr[minRow][c] = count++;
            }
            minRow++;

            // Top to bottom
            for (int r = minRow; r <= maxRow; r++) {
                arr[r][maxCol] = count++;
            }
            maxCol--;

            // Right to left
            for (int c = maxCol; c >= minCol; c--) {
                if (count > n * n) break;
                arr[maxRow][c] = count++;
            }
            maxRow--;

            // Bottom to top
            for (int r = maxRow; r >= minRow; r--) {
                if (count > n * n) break;
                arr[r][minCol] = count++;
            }
            minCol++;
        }

        return arr;
    }
}
