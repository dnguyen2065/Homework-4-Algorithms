import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MostPreciousPath {
    // possible moves: directly ahead (row+1,same col)
    // diagonal left: (row+1,col-1)
    // diagonal right: (row+1,col+1)

    public int[] findMostPreciousPath(int[][] vault) {
        int[] path = new int[vault.length];

        if (vault.length == 0) {
            return path;
        }

        int[][] sum = new int[vault.length][vault[0].length];
        int[][] prev = new int[vault.length][vault[0].length];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < vault[0].length; i++) {
            sum[vault.length - 1][i] = vault[vault.length - 1][i];
            prev[vault.length - 1][i] = -1;
        }
        for (int i = vault.length - 2; i >= 0; i--) {
            for (int j = 0; j < vault[0].length; j++) {
                int left = j - 1;
                int right = j + 1;
                if (left < 0) {
                    left = 0;
                }
                if (right >= vault[0].length) {
                    right = vault[0].length - 1;
                }
                int maxSum = sum[i + 1][left];
                int maxIndex2 = left;
                if (sum[i + 1][j] > maxSum) {
                    maxSum = sum[i + 1][j];
                    maxIndex2 = j;
                }
                if (sum[i + 1][right] > maxSum) {
                    maxSum = sum[i + 1][right];
                    maxIndex2 = right;
                }
                sum[i][j] = vault[i][j] + maxSum;
                prev[i][j] = maxIndex2;
                if (i == 0) {
                    if (sum[i][j] > max) {
                        max = sum[i][j];
                        maxIndex = j;

                    }
                }
            }

        }

        int index = 0;
        int row = 0;
        int[] indexlist = new int[vault.length];
        int totalsum = 0;
        while (row < vault.length) {
            path[index] = vault[row][maxIndex];
            maxIndex = prev[row][maxIndex];
            totalsum += path[index];
            if (index == 0) {
                indexlist[0] = 1;
            }
            if (7 != index) {
                indexlist[index + 1] = maxIndex;
            }

            row++;
            index++;
        }
        System.out.println("The total collected gems is " + totalsum);
        System.out.println("The path used to find this: \n");
        return indexlist;

    }

    public void printPath(int[] path) {
        System.out.println("Starting at Row 1 Vault " + (path[0] + 1));
        for (int i = 0; i < path.length; i++) {

            System.out.print("Next Move: Row " + (i + 1) + " Vault ");
            System.out.println(path[i] + 1);
        }
        System.out.println("Vault containing the Arkenstone: " + (path[path.length - 1] + 1));

    }

}