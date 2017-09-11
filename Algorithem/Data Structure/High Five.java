There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(Record rec : results){
            if(!map.containsKey(rec.id)){
                map.put(rec.id, new PriorityQueue<Integer>());
            }
            PriorityQueue heap = map.get(rec.id);
            heap.add(rec.score);

            if(heap.size() > 5){
                heap.poll();
            }
        }
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            PriorityQueue<Integer> score = entry.getValue();
            double average = 0;
            for(int i = 0; i < 5; i++)
                average += score.poll();
            average /= 5.0;
            res.put(id, average);
        }
        return res;
    }
}
