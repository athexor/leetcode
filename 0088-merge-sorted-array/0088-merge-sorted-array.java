class Solution {
    public void merge(int[] C, int o, int[] B, int m) {
        int n = o;
        int[] A = new int[n];
        for(int i=0; i<=n-1; i++){
            A[i] = C[i];
        }

        int i=0;
        int j=0;
        int k=0;
        while(i <= n-1 && j <= m-1){
            if(A[i] <= B[j]){
                C[k] = A[i];
                i++;
                k++;
            }else{
                C[k] = B[j];
                j++;
                k++;
            }
        }

        while(i <= n-1){
            C[k] = A[i];
            i++;
            k++;
        }

        while(j <= m-1){
            C[k] = B[j];
            j++;
            k++;
        }
    }
}

/**
 * if(o == 0 && m == 0)
 *     return;
 * 
 * if(o == 0){
 *     for(int i=0; i<=m-1; i++){
 *         C[i] = B[i];
 *     }
 *     return;
 * }
 * 
 * if(m == 0)
 *     return;
 *
 * We can skip handling the above edge cases (o == 0, m == 0, or both),
 * as the while loops above already handle these cases correctly.
 *
 * If both o and m are 0, all three while loops are skipped entirely,
 * and C simply remains empty.
 *
 * If o == 0 (C is empty), the first while loop is skipped since i > n-1
 * immediately, and the final "while(j <= m-1)" loop copies all of B into C.
 *
 * If m == 0 (B is empty), the first while loop is skipped since j > m-1
 * immediately, and the "while(i <= n-1)" loop copies all of A back into C.
 *
 * Note: We cannot simply do "C = B" as a shortcut when o == 0, since that
 * only reassigns the local reference variable C to point at B within this
 * method's scope. Java passes array references by value, so the caller's
 * original array is left unchanged. To actually update it, we must copy
 * B's elements into C one by one, e.g.:
 *
 * for (int i = 0; i <= m - 1; i++) {
 *     C[i] = B[i];
 * }
 */