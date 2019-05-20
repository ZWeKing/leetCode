package no947;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class Solution {

    int island = 0;

    public int removeStones(int[][] stones) {

        int length = stones.length;
        island = length;

        int[][] matrix = new int[length][length];
        //构建临接矩阵
        for (int i = 0;i < length;i++) {
            matrix[i][i] = 1;
            for(int j = i+1; j < length;j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }


        int[] visited = new int[length];

        for(int i=0;i<length;i++){
            dfs(matrix,i,visited);
        }

        return stones.length-island;

    }

    public void dfs(int[][] matrix,int index,int[] visited){

        visited[index] = 1;

        for(int i=0;i<matrix.length;i++){
            if ( matrix[index][i] == 1 && visited[i] == 0){
                island--;
                dfs(matrix,i,visited);
            }
        }

    }


    public static void main(String[] args){

        int[][] stones = new int[][]{{1,2},{4,7},{4,5},{3,1},{6,3},{1,7},{3,7},{0,3},{3,5}};
        System.out.println(new Solution().removeStones(stones));
    }
}
