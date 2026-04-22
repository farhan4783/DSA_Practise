import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String>     twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();

     
        for (String query : queries) {
            if (canBeTransformed(query, dictionary)) {
                result.add(query);
            }
        }

        return result;
    }

    private boolean canBeTransformed(String query, String[] dictionary) {
        for (String word : dictionary) {
            int edits = 0;
            
           
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) != word.charAt(i)) {
                    edits++;
                }
                
                
                if (edits > 2) {
                    break;
                }
            }

           
            if (edits <= 2) {
                return true;
            }
        }
        return false;
    }
}
