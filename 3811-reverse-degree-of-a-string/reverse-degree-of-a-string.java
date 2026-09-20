class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int p = (int)s.charAt(i);
            p = p-96;
            ans += (i+1)*(26-p+1);
        }
        return ans;
    }
}