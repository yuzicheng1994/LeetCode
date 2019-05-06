//https://leetcode-cn.com/problems/sort-array-by-parity/
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        while (leftIndex < rightIndex) {
            if (A[leftIndex] % 2 == 0 && A[rightIndex] % 2 == 0)
                leftIndex++;
            else if (A[leftIndex] % 2 != 0 && A[rightIndex] % 2 != 0)
                rightIndex--;
            else if (A[leftIndex] % 2 != 0 && A[rightIndex] % 2 == 0) {
                int cur = A[leftIndex];
                A[leftIndex] = A[rightIndex];
                A[rightIndex] = cur;
                leftIndex++;
                rightIndex--;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }

        return A;
    }
}
