Given two words (beginWord and endWord), and a dictionary word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 1;
        }
        Queue<String>queue = new LinkedList<>();
        Set<String>set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int length = 1;
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                ArrayList<String>nextWords = findNextWords(word, wordList);
                for(String nextWord: nextWords){
                    if(set.contains(nextWord)){
                        continue;
                    }
                    if(nextWord.equals(endWord)){
                        return length;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }
        return 0;
    }
    private ArrayList<String> findNextWords(String word, List<String> wordList){
        ArrayList<String>list = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c < 'z'; c++){
                if(word.charAt(i) == c){
                    continue;
                }
                String nextWord = replace(word, i, c);
                if(wordList.contains(nextWord)){
                    list.add(nextWord);
                }
            }
        }
        return list;
    }
    private String replace(String word, int i, char c ){
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }

}
