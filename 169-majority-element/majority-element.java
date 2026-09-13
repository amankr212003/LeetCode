//method 1 - brute force tc O(n) sc O(n)

// class Solution {
//     public int majorityElement(int[] nums) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         // Count frequency of each element
//         for (int n : nums) {
//             if (map.containsKey(n)) {
//                 map.put(n, map.get(n) + 1);
//             } else {
//                 map.put(n, 1);
//             }
//         }

//         /* Way 1: Normal loop
//         Integer maxKey = null;
//         int maxVal = Integer.MIN_VALUE;

//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

//             // Find element with maximum frequency
//             if (entry.getValue() > maxVal) {
//                 maxVal = entry.getValue();
//                 maxKey = entry.getKey();
//             }
//         }

//         return maxKey;*/

//         // Way 2: Using Stream
//         Integer max = map.entrySet().stream()
//         .max(Map.Entry.comparingByValue())
//         .map(Map.Entry::getKey)
//         .orElse(null);

//         return max;
//     }
// }

//Method 2 optimal tc O(n) sc O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int c=0;

        for(int num:nums){
            if(c==0)
                candidate = num;

            if(num==candidate)
                c++;
            else
                c--;
        }
        return candidate;
    }
}