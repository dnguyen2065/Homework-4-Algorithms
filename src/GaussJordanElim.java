import java.util.Arrays;

public class GaussJordanElim {

    // Implements Gaussian elimination with partial pivoting
    // Input: Matrix A[1..n, 1..n] and column-vector b[1..n]
    // Output: An equivalent upper-triangular matrix in place of A and the
    // corresponding right-hand side values in place of the (n + 1)st column
    // for i←1
    // to n do A[i,n+1]←b[i] // appends b to A as the last column
    // for i←1
    // to n−1 do pivotrow←i for j←i+1
    // to n do if|A[j,i]|>|A[pivotrow,i]|pivotrow←j for k←
    // i to n+1 do

    // swap(A[i, k], A[pivotrow, k])
    // for j ← i + 1 to n do
    // temp ← A[j, i] / A[i, i]
    // for k ← i to n + 1 do
    // A[j, k]← A[j, k] − A[i, k] ∗ temp

    public void BetterForwardElimination(int[][] matrix, int colVect) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            matrix[i][n + 1] = colVect;
        }
        for (int i = 0; i < n - 1; i++) {

        }
    }

    public float[][] BFEWithGaussJordanElim(float[][] matrix, float[] colVect, int n) {

        float[][] fullArr = new float[n][n + 1];
        int pivotRowAccum;
        boolean swap;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == n) {
                    fullArr[i][j] = colVect[i];
                } else {
                    fullArr[i][j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            swap = false;
            pivotRowAccum = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(fullArr[j][i]) > Math.abs(fullArr[pivotRowAccum][i])) {
                    pivotRowAccum = j;
                    swap = true;
                }

            }
            if (swap) {
                float[] temp;
                temp = fullArr[i];
                fullArr[i] = fullArr[pivotRowAccum];
                fullArr[pivotRowAccum] = temp;

            }
            float pivotMult = fullArr[i][i];
            for (int k = i; k < n + 1; k++) {
                fullArr[i][k] = fullArr[i][k] / pivotMult;
            }
            for (int l = 0; l < n; l++) {
                if (l != i) {
                    float mult = fullArr[l][i] / fullArr[i][i];
                    for (int m = i; m < n + 1; m++) {
                        fullArr[l][m] = fullArr[l][m] - fullArr[i][m] * mult;
                    }
                }
            }
        }
        return fullArr;
    }

}
