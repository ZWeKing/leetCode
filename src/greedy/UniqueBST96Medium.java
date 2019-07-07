package greedy;

public class UniqueBST96Medium {
    public int numTrees(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = getCount(i,dp);
        }

        return dp[n-1];


    }

    public int getCount(int index,int[] dp) {

        int result = 0;
        for(int j = 0; j <= index; j++) {
            int p1 = j - 0;
            int p2 = index -j;

            int step = (p1 > 1 ? dp[p1-1] : 1) * (p2 > 1 ? dp[p2-1] : 1);

            result = result + step;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new UniqueBST96Medium().numTrees(10));
    }
}
