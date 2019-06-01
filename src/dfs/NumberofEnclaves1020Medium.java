package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 * 1020. Number of Enclaves
 * Medium
 *
 * 80
 *
 * 11
 *
 * Favorite
 *
 * Share
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 *
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 *
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 * Example 2:
 *
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:
 * All 1s are either on the boundary or can reach the boundary.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * All rows have the same size.
 */
public class NumberofEnclaves1020Medium {

    public int numEnclaves(int[][] A) {
        if (A == null) {
            return 0;
        }

        int rowLength = A.length;
        int columLength = A[0].length;

        Map<String,String> visited = new HashMap<>();

        int landCount = 0;

        for (int i = 0; i< rowLength; i++) {
            for (int j = 0; j< columLength; j++) {
                if (A[i][j] == 1) {
                    landCount++;
                }
            }
        }

        if (landCount == 0) {
            return 0;
        }

        int columBoundaryIndex = columLength - 1;
        int rowBoundaryIndex = rowLength - 1;

        for (int j=0; j< columLength; j++) {
            //A[0][j]
            if (ifLandAndNoVisited(0,j,A,visited)) {
                dfs(A,0,j,visited);
            }

            //A[rowBoundaryIndex][j]
            if (ifLandAndNoVisited(rowBoundaryIndex,j,A,visited)) {
                dfs(A,rowBoundaryIndex,j,visited);
            }

        }

        for (int j=0; j< rowLength; j++) {

            //A[j][0]
            if (ifLandAndNoVisited(j,0,A,visited)) {
                dfs(A,j,0,visited);
            }

            //A[j][columBoundaryIndex]
            if (ifLandAndNoVisited(j,columBoundaryIndex,A,visited)) {
                dfs(A,j,columBoundaryIndex,visited);
            }

        }

        return landCount - visited.size();
    }


    public void dfs(int[][] A, int row, int colum, Map<String,String> visited) {

        visited.put(getKey(row,colum),null);

        int rowAdd = row + 1;
        int columAdd = colum + 1;
        int rowMinus = row - 1;
        int columMinus = colum - 1;

        if (rowAdd < A.length && ifLandAndNoVisited(rowAdd,colum,A,visited)) {
            dfs(A,rowAdd,colum,visited);
        }

        if (columAdd < A[0].length && ifLandAndNoVisited(row,columAdd,A,visited)) {
            dfs(A,row,columAdd,visited);
        }

        if(rowMinus > 0 && ifLandAndNoVisited(rowMinus,colum,A,visited)) {
            dfs(A,rowMinus,colum,visited);
        }

        if(columMinus > 0 && ifLandAndNoVisited(row,columMinus,A,visited)) {
            dfs(A,row,columMinus,visited);
        }

    }

    private boolean ifLandAndNoVisited(int row,int column,int[][] A,Map visited) {
        return A[row][column] == 1 && !visited.containsKey(getKey(row,column));
    }

    private String getKey(int row,int column) {
        return row + "|" + column;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,0,0,1,1,0,1,0,1,0,1,1,0},{0,0,1,0,0,1,0,1,0,1,1,1,0},{1,0,1,1,1,0,1,1,0,0,0,0,1},{1,1,1,1,1,1,0,0,0,1,0,1,0},{0,1,0,0,1,0,1,0,0,1,0,0,0},{0,1,0,1,0,1,1,0,0,1,0,0,1},{1,0,1,0,0,1,1,1,0,0,0,0,1},{0,0,1,1,1,1,0,0,0,1,1,1,1},{1,1,1,0,1,1,0,1,0,0,1,0,1},{0,1,0,1,1,1,1,1,1,1,1,0,0},{1,1,1,0,1,1,0,1,1,1,1,0,0},{1,0,0,1,1,0,1,1,1,1,0,0,1}};
        System.out.println(new NumberofEnclaves1020Medium().numEnclaves(A));
    }
}
