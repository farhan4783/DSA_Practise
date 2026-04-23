import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            
            
            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder line = new StringBuilder();
            int count = j - i; 

           
            if (j == words.length || count == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
           
            else {
                int totalSpaces = maxWidth - (lineLength - (count - 1));
                int spaceBetween = totalSpaces / (count - 1);
                int extraSpaces = totalSpaces % (count - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spaceBetween + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j; 
        }

        return result;
    }
}
