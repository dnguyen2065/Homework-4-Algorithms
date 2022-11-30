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
         * ForwardElimination because it could be distorted by rounding errors from when
         * the scaling factor gets so large that the difference between numbers of great
         * magnitude creates the possibility of massive rounding error.
         * 
         * How does the BetterForwardElimination algorithm on page 211 of Levitin rem-
         * edy this?
         * 
         * ANSWER: BetterForwardElimination solves this problem by implementing partial
         * pivoting. Partial pivoting works by looking for a row with the largest
         * absolute value
         * of the coefficient in the ith column and swap it with the ith row then use
         * the
         * resultant matrix as the ith iteraiton pivot.
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
         * ANSWER: In the first for loop of BetterForwardElimination the bottom 2 rows become 
         * equivalent. Because they are equivalent you cant use partial pivoting on them.
         * 
         * What can be done to remedy this shortcoming in the algorithm?
         * 
         * ANSWER: 
         * 
         */

public class App {
    public static void main(String[] args) throws Exception {

    }
}
