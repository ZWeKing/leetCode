package no547;

public class Solution2 {
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
            count = n;
            for (int i = 0;i < n;i++) {
                parent[i] = i;
            }
        }

        /**
         * 查看当前的节点的父节点
         * @param p
         * @return
         */
        public int find(int p) {
            return parent[p];
        }

        /**
         * 合并节点p和节点q
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

            for (int m = 0; m< parent.length;m++) {
                if (parent[m] == i) {
                    parent[m] = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(new Solution2().findCircleNum(M));
    }
}
