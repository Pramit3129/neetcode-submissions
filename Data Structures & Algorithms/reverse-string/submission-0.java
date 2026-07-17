class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i <n/2; i++){
            int p1 = i;
            int p2 = n-1-i;
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;
        }
    }
}