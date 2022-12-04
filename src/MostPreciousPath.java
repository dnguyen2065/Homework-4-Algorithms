import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MostPreciousPath {
    // possible moves: directly ahead (row+1,same col)
    // diagonal left: (row+1,col-1)
    // diagonal right: (row+1,col+1)

    public int[] longestPath(int[][] vault) {
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
        while (row < vault.length) {
            path[index] = vault[row][maxIndex];
            // System.out.println(Arrays.toString(vault[row]));
            maxIndex = prev[row][maxIndex];
            row++;
            index++;
        }

        for (int i = vault.length - 1; i >= 0; i--) {
            for (int j = vault[i].length - 1; j >= 0; j--) {
                if (i == vault.length - 1) {
                    List<Integer> currentlayer = Arrays.stream(vault[i]).boxed().collect(Collectors.toList());
                    Collections.max(currentlayer);
                }

            }
        }

        return path;

    }

    public void analyzePath(int[][] grid, int[][] max) {
        LinkedList<Path> path = new LinkedList<Path>();
        int startingPoint = 0;
        int gems = 0;
        int vault = 0;

        for (int row = max.length - 1; row > -1; row--) {
            if (row == max.length - 1) {
                for (int col = 0; col < max[row].length; col++) {
                    if (gems < max[row][col]) {
                        gems = max[row][col];
                        vault = col + 1;
                    }
                }
                path.add(0, new Path(row, vault - 1, gems));
            } else {
                int endRow = path.get(0).getRow();
                int endCol = path.get(0).getCol();
                int maxGems = max[endRow][endCol] - grid[endRow][endCol];
                for (int i = -1; i < 2; i++) {
                    if (!((endCol + i) < 0 || (endCol + i) >= max[row].length)) {
                        if (max[row][endCol + i] == maxGems) {
                            path.add(0, new Path(row, endCol + i, maxGems));
                            if (row == 0) {
                                startingPoint = endCol + i + 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Starting Point: " + startingPoint);
        System.out.println("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print("Row: " + (path.get(i).getRow() + 1) + " Col: " + (path.get(i).getCol() + 1));
            System.out.println();
        }
        System.out.println("The total Gems: " + gems);
        System.out.println("Vault Number: " + vault);
    }

    public void initArray(int[][] maxPath) {
        for (int i = 0; i < maxPath.length; i++) {
            for (int j = 0; j < maxPath[i].length; j++) {
                maxPath[i][j] = 0;
            }
        }
    }

    public void maxPathFill(int[][] grid, int[][] maxPath) {
        int maxRows = grid.length;
        int pathVal;

        for (int row = 0; row < maxRows; row++) {
            int maxCol = grid[row].length;
            for (int col = 0; col < maxCol; col++) {
                if (row == 0) {
                    maxPath[row][col] = grid[row][col];
                } else {
                    for (int i = -1; i < 2; i++) {
                        if (!((col + i) < 0 || (col + i) >= maxCol)) {
                            pathVal = maxPath[row - 1][col] + grid[row][col + i];
                            if (pathVal > maxPath[row][col + i]) {
                                maxPath[row][col + i] = pathVal;
                            }
                        }
                    }
                }
            }
        }
    }

}

class Path {
    int row;
    int col;
    int gems;

    public Path(int row, int col, int gems) {
        this.row = row;
        this.col = col;
        this.gems = gems;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}