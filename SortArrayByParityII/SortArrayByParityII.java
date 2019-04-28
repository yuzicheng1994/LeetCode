//https://leetcode-cn.com/problems/sort-array-by-parity-ii/
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int evenIndex = 0;
        int oddIndex = 1;
        while (evenIndex <= A.length - 1 && oddIndex <= A.length) {
            if (A[evenIndex] % 2 != 0) {
                int temp = A[oddIndex];
                A[oddIndex] = A[evenIndex];
                A[evenIndex] = temp;
                oddIndex += 2;
            } else {
                evenIndex += 2;
            }
        }

        return A;
    }
}
