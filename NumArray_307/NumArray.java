//https://leetcode-cn.com/problems/range-sum-query-mutable/
public class NumArray {
    private int[] data;
    private int[] tree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            data = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            tree = new int[data.length * 4];
            buildSegmentTree(0, 0, data.length - 1);
        }
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void update(int i, int val) {
        update(0, 0, data.length - 1, i, val);
    }

    private void update(int treeIndex, int l, int r, int index, int val) {
        if (l == r) {
            tree[treeIndex] = val;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index <= mid)
            update(leftTreeIndex, l, mid, index, val);
        else
            update(rightTreeIndex, mid + 1, r, index, val);

        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public int sumRange(int i, int j) {
        if (data == null)
            throw new IllegalArgumentException("Array is null");
        return sumRange(0, 0, data.length - 1, i, j);
    }

    private int sumRange(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryR <= mid)
            return sumRange(leftTreeIndex, l, mid, queryL, queryR);
        else if (queryL >= mid + 1)
            return sumRange(rightTreeIndex, mid + 1, r, queryL, queryR);

        int leftResult = sumRange(leftTreeIndex, l, mid, queryL, mid);
        int rightResult = sumRange(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return leftResult + rightResult;
    }
}