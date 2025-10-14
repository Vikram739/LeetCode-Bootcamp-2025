class FindAnan {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) {
            return result;
        }
        
        // Frequency arrays for characters (only lowercase letters)
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Build frequency map for p and initial window in s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check if first window is an anagram
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        
        // Slide the window across s
        for (int i = p.length(); i < s.length(); i++) {
            // Add new character to the window
            sCount[s.charAt(i) - 'a']++;
            
            // Remove the leftmost character from the window
            sCount[s.charAt(i - p.length()) - 'a']--;
            
            // Check if current window is an anagram
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
}