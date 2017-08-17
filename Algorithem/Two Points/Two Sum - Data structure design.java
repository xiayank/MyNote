Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.


Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false

public class TwoSum {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    public TwoSum() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
       if(map.containsKey(number)){
           map.put(number, map.get(number) + 1);
       }else{
           list.add(number);
           map.put(number, 1);
       }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for(Integer i : list){
            int num = value - i;
            if((num == i && map.get(i) > 1) || (num != i && map.containsKey(num))){
                return true;
            }
        }
        return false;
    }
}
