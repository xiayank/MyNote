Given two arrays, write a function to compute their intersection.
Notice

Each element in the result must be unique.
The result can be in any order.
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

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
        int[]temp = new int[nums1.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(index == 0 || temp[index - 1] != nums1[i]){
                    temp[index++] = nums1[i];
                }
                i++;
                j++; //不在上一个if中，每次都要++；
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] res = new int[index];
        for(int k = 0; k < index; k++){
            res[k] = temp[k];
        }
        return res;
    }
}
