class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list.add(nums2[i]);
        }

        Collections.sort(list);
        int n = list.size();
        if(n%2!=0){
            return (double)list.get(n/2);
        }
        int m = n/2;
        return (double) (list.get(m)+list.get(m-1))/2;
    }
}