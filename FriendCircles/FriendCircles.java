//https://leetcode-cn.com/problems/friend-circles/
public class FriendCircles {
    private int[] rank;
    private int[] parent;

    private int find(int p) {
        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    public int findCircleNum(int[][] M) {
        int count = M.length;

        parent = new int[M.length];
        rank = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (i != j && !isConnected(i, j) && M[i][j] == 1) {
                    unionElements(i, j);
                    count--;
                }
            }
        }

        return count;
    }
}
