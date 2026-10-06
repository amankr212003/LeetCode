class Solution {
    public int minAddToMakeValid(String s) {
        int balance=0;
        int addition=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                balance++;
            }
            else{
                if(balance>0){
                    balance--;
                }
                else{
                    addition++;
                }
            }
        }
        return balance+addition;

    }
}