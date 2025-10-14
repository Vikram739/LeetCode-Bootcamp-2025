class RevWords {
    public String reverseWords(String s) {
        // Trim and split approach - most readable and efficient in Java
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        return String.join(" ", words);
    }
    
    // Alternative: Manual parsing approach (more control, similar performance)
    public String reverseWordsManual(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        
        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // Find the end of the word
            int end = i;
            
            // Find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            
            // Add word to result if found
            if (end >= 0 && i < end) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(s.substring(i + 1, end + 1));
            }
        }
        
        return result.toString();
    }
    
    // Follow-up: In-place solution (if string were mutable like char array)
    public String reverseWordsInPlace(String s) {
        // Convert to char array since String is immutable in Java
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        // Step 1: Reverse the entire string
        reverse(chars, 0, n - 1);
        
        // Step 2: Reverse each word and remove extra spaces
        int writeIdx = 0;
        int i = 0;
        
        while (i < n) {
            // Skip spaces
            while (i < n && chars[i] == ' ') {
                i++;
            }
            
            // Mark start of word
            int start = writeIdx;
            
            // Copy word
            while (i < n && chars[i] != ' ') {
                chars[writeIdx++] = chars[i++];
            }
            
            // Reverse the word
            if (start < writeIdx) {
                reverse(chars, start, writeIdx - 1);
                // Add space after word (except for last word)
                if (writeIdx < n) {
                    chars[writeIdx++] = ' ';
                }
            }
        }
        
        // Handle case where last character is a space
        int len = (writeIdx > 0 && chars[writeIdx - 1] == ' ') ? writeIdx - 1 : writeIdx;
        return new String(chars, 0, len);
    }
    
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}