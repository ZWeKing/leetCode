package no547;
/**
 * 547. Friend Circles
 * Medium
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class Solution3 {

    public int findCircleNum(int[][] M) {

        DisjointSet disjointSet = new DisjointSet(M.length);

        for (int i = 0;i < M.length;i++) {
            for(int j=i+1;j < M.length;j++) {
                if (M[i][j] == 1) {
                    disjointSet.union(i,j);
                }
            }
        }
        return disjointSet.count;
    }

    class DisjointSet {

        /**
         * 记录每个节点的父节点,默认情况下每个节点的父节点是其本身
         */
        private int[] parent;

        private int[] size;
        /**
         * 表示当前并查集有多少个集合
         */
        private int count;

        public int[] getParent() {
            return parent;
        }

        public int getCount() {
            return this.count;
        }

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0;i < n;i++) {
                parent[i] = i;
            }
        }

        /**
         * 查找时利用路径压缩算法进行路径压缩，减少路径的长度
         * @param p
         * @return
         */
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        /**
         * 合并节点p和节点q,考虑节点p和节点q所在子树大小进行合并
         * @param p
         * @param q
         */
        public void union(int p,int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) {
                return;
            }

            //每次合并都减少当前并查集中的集合个数
            count--;

            if (size[i] > size[j] ) {
                parent[j] = i;
                size[i] += size[j];
            } else {
                parent[i] = j;
                size[j] += size[i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(new Solution3().findCircleNum(M));
    }
}
