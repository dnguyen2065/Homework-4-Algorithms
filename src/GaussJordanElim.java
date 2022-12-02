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

    public float[][] BFEWithGaussJordanElim(float[][] matrix, float[] colVect, int n){

        float [][] fullArr = new float[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                if(j==n){
                    fullArr[i][j] = colVect[i];
                }else{
                    fullArr[i][j] = matrix[i][j];
                }
            }
        }
        for(){
            for()
            for()
            for(){
                for()
            }
        }
    }

    public int PerformOperation(float a[][], int n) {
        int i, j, k = 0, c, flag = 0, m = 0;
        float pro = 0;

        // Performing elementary operations
        for (i = 0; i < n; i++) {
            if (a[i][i] == 0) {
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;
                if ((i + c) == n) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k <= n; k++) {
                    float temp = a[j][k];
                    a[j][k] = a[j + c][k];
                    a[j + c][k] = temp;
                }
            }

            for (j = 0; j < n; j++) {

                // Excluding all i == j
                if (i != j) {

                    // Converting Matrix to reduced row
                    // echelon form(diagonal matrix)
                    float p = a[j][i] / a[i][i];

                    for (k = 0; k <= n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                }
            }
        }
        for (int l = 0; l < n; l++) {
            System.out.print(a[l][n] / a[l][l] + " ");
        }

        return flag;
    }
}
