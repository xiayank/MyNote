Given two arrays, write a function to compute their intersection.
Notice

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, index = 0;
        ArrayList<Integer>res = new ArrayList<>();

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;

            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int k = 0;
        int[] inter = new int[res.size()];
        for(Integer number: res){
            inter[k++] = number;
        }

        return inter;
    }
}
