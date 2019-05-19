package no207;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化访问数组
        int[] visited = new int[numCourses];
        //根据课程信息构建图数据
        GraphNode[] graphNodes = new GraphNode[numCourses];
        for (int i = 0; i < numCourses; i++){
            visited[i] = -1;
            graphNodes[i] = new GraphNode();
            graphNodes[i].value = i;
        }

        for( int i = 0;i < prerequisites.length; i++){
            GraphNode startNode = graphNodes[prerequisites[i][0]];
            GraphNode endNode = graphNodes[prerequisites[i][1]];
            startNode.nextNodes.add(endNode);
        }

        for (int i = 0; i < graphNodes.length; i++){
            if(visited[i] == -1){
               if (!dfsGraph(graphNodes[i],visited)) {
                   return false;
               }
            }
        }

        return  true;

    }

    public boolean dfsGraph(GraphNode node,int[] visited){
        //标识当前节点正在访问中
        visited[node.value] = 0;

        for(GraphNode graphNode:node.nextNodes){

            if (visited[graphNode.value] == -1) {
                if (!dfsGraph(graphNode,visited)) {
                    return false;
                }
            } else if (visited[graphNode.value] == 0) {
                return false;
            }
        }

        visited[node.value] = 1;
        return true;
    }

    class GraphNode {
        int value;
        List<GraphNode> nextNodes = new ArrayList<>();
    }

    public static void main(String[] args){
        int[][] prerequisites = new int[][]{{0,1},{3,0}};
        System.out.println(new Solution().canFinish(4,prerequisites));
    }


}

