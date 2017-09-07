Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Notice

You are not suppose to use the library sort function for this problem.

k <= n

Have you met this question in a real interview? Yes
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].


class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0){
            return;
        }
        sort(colors, 0, colors.length - 1, 1, k);
    }

    private void sort(int[] colors, int start, int end, int colorStart, int colorEnd){
        if(start > end){
            return;
        }
        if(colorStart == colorEnd){
            return;
        }
        int colorMid = colorStart + (colorEnd - colorStart) / 2;
        int left = start, right = end;
        while(start <= end){
            while(start <= end && colors[start] <= colorMid){
                start++;
            }
            while(start <= end && colors[end] > colorMid){
                end--;
            }
            if(start <= end){
                int temp = colors[start];
                colors[start] = colors[end];
                colors[end] = temp;
                start++;
                end--;
            }

        }
        sort(colors, left, start, colorStart, colorMid);
        sort(colors, end, right, colorMid + 1, colorEnd);
    }
}
