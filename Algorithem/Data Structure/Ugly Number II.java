Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long>heap = new PriorityQueue<>();
        heap.add(Long.valueOf(1));
        Long[] magic = new Long[]{Long.valueOf(2),Long.valueOf(3),Long.valueOf(5)};
        Set<Long>set = new HashSet<>();
        Long head = Long.valueOf(1);
        for(int i = 0; i < n; i++){
            head = heap.poll();
            for(int j = 0; j < 3; j++){
                if(!set.contains(magic[j] * head)){
                    heap.add(magic[j] * head);
                    set.add(magic[j] * head);
                }
            }
        }
        return head.intValue();
    }
}
