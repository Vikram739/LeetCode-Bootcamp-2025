class StrtoInt {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Check if we've reached the end
        if (i == n) return 0;
        
        // Step 2: Determine sign
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits to integer
        int result = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        int maxMod10 = Integer.MAX_VALUE % 10;
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Step 4: Check for overflow before multiplying and adding
            // For positive: result > 214748364 OR (result == 214748364 AND digit > 7)
            // For negative: result > 214748364 OR (result == 214748364 AND digit > 8)
            if (result > maxDiv10 || (result == maxDiv10 && digit > maxMod10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}