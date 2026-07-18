class Solution {
    public String addBinary(String a, String b)  {
        StringBuilder ans = new StringBuilder();
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        while(n1 >= 0 && n2 >= 0){
            int curA = Integer.parseInt(String.valueOf(a.charAt(n1)));
            int curB = Integer.parseInt(String.valueOf(b.charAt(n2)));
            int curSum = curA + curB + carry;
            if(curSum == 3){
                ans.append(1);
                carry = 1;
            }else if(curSum == 2){
                ans.append(0);
                carry = 1;
            }else if(curSum == 1){
                ans.append(1);
                carry = 0;
            }else{
                ans.append(0);
                carry = 0;
            }
            n1--;
            n2--;
        }
        while (n1 >= 0){
            int curA = Integer.parseInt(String.valueOf(a.charAt(n1)));
            int curSum = curA+carry;
            if(curSum == 2){
                ans.append(0);
                carry = 1;
            }else if(curSum == 1){
                ans.append(1);
                carry = 0;
            }else{
                ans.append(0);
                carry = 0;
            }
            n1--;
        }

        while (n2 >= 0){
            int curB = Integer.parseInt(String.valueOf(b.charAt(n2)));
            int curSum = curB+carry;
            if(curSum == 2){
                ans.append(0);
                carry = 1;
            }else if(curSum == 1){
                ans.append(1);
                carry = 0;
            }else{
                ans.append(0);
                carry = 0;
            }
            n2--;
        }
        if(carry == 1){
            ans.append(1);
        }

        ans.reverse();
        return ans.toString();
    }
}