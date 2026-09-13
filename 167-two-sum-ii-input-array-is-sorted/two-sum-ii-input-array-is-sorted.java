// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] res = new int[2];
//         int l=0;
//         int r=numbers.length-1;

//         while(numbers[l]+numbers[r]!=target){
//             if(numbers[l]+numbers[r]>target){
//                 r--;
//             }
//             else{
//                 l++;
//             }
//         }
//         res[0] = l+1;
//         res[1] = r+1;
//         return res;
//     }
// }

class Solution {
    public int[] twoSum(int[] n, int target) {
        /*Method 1 ... TC-O(n^2)
        int num = n.length;
        int[] a = new int[2];

        for(int i = 0; i < num - 1; i++) {

            for(int j = i + 1; j < num; j++) {

                if(n[i] + n[j] == target) {
                    a[0] = i+1; //as indices in problem starts with 1 not 0
                    a[1] = j+1;
                    return a;
                }
            }
        }

        return a;*/
        //Method 2 - Optimal Approach (Two Pointer) tc-O(n)
         int left = 0;
        int right = n.length - 1;

        while(left < right) {

            int sum = n[left] + n[right];

            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }

            else if(sum < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return new int[]{};
    }
}