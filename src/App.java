import java.util.Arrays;

/*
         * Question 1: -----------------------------------------------------------------
         * (5 Points) Explain why the (repaired1)ForwardElimination algorithm on page
         * 210 of Levitin fails to provide a solution for:
         * 
         * x1 + x2 + x3 = 6
         * x1 + x2 + 2x3 = 9
         * x1 + 2x2 + 3x3 = 14
         * 
         * despite the fact that x = (1, 2, 3) or x1 = 1, x2 = 2, x3 = 3 can be easily
         * verified as a solution to the system.
         * 
         * ANSWER: This system of equations cannot be solved by normal
         * ForwardElimination because it belongs to an edge case that would divide by zero. The forward
         * elimination algorithm does not take this case into account when a[i,i] = 0.
         * 
         * How does the BetterForwardElimination algorithm on page 211 of Levitin rem-
         * edy this?
         * 
         * ANSWER: BetterForwardElimination solves this problem by implementing partial
         * pivoting. Partial pivoting allows a[i,i] to never equal zero solving the issue.
         *
         * 
         * 
         * Question 2:
         * --------------------------------------------------------------------
         * 2. (10 Points) Explain in some detail why the BetterForwardElimination
         * algorithm on page 211 of Levitin fails to provide a solution for:
         * 
         * x1 + x2 + x3 = 6
         * x1 + x2 + 2x3 = 9
         * 2x1 + 2x2 + 3x3 = 15
         * 
         * despite the fact that x = (1, 2, 3) or 1 = 1, x2 = 2, x3 = 3 can be easily
         * verified as a solution to the system.
         * 
         * ANSWER: This wont work because the BetterForwardElimination algorithm does not take
         * into account systems whos answer is undefined or whos has an infinte solution. in this case
         * 1,2,3 is one of infinite possinble solutions.
         * 
         * What can be done to remedy this shortcoming in the algorithm?
         * 
         * ANSWER: to fix this you can add edge cases that find if there are infinitely many or no solution.        * 
         */

public class App {

    public static void main(String[] args) throws Exception {
        // Question 3: ---------------------------------------------------
        System.out.println("Question 3: --------------------");
        GaussJordanElim gje = new GaussJordanElim();
        float[][] matrix = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 4, -3, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 3, -2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0 },
                { 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1 } };
        float[] colVect = { 364, 4, 16, 36, 64, 100, 79, 61, 0, 0, 0, -42 };
        float[][] end = gje.BFEWithGaussJordanElim(matrix, colVect, 12);
        for (int i = 0; i < 12; i++) {
            System.out.println("x_" + (i + 1) + " = " + Math.round(end[i][12]));
        }
        System.out.println("Question 4 -----------------------");

        int[][] grid = {
                { 35, 89, 52, 66, 82, 20, 95, 21 },
                { 79, 5, 14, 23, 78, 37, 40, 74 },
                { 32, 59, 17, 25, 31, 4, 16, 63 },
                { 91, 11, 77, 48, 13, 71, 92, 15 },
                { 56, 70, 47, 64, 22, 88, 67, 12 },
                { 83, 97, 94, 27, 65, 51, 30, 7 },
                { 10, 41, 1, 86, 46, 24, 53, 93 },
                { 96, 33, 44, 98, 75, 68, 99, 84 }
        };

        MostPreciousPath mpp = new MostPreciousPath();
        mpp.printPath(mpp.findMostPreciousPath(grid));
    }
}
