class Solution {
    public int cnt1(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += n & 1; 
            n = n >> 1;
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i <= n; i++){
            ans[i] = cnt1(i);
        }
        return ans;
    }
}
