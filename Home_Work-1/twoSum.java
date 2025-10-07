class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // Need a larger sum, move left pointer right
                left++;
            } else {
                // Need a smaller sum, move right pointer left
                right--;
            }
        }
        
        // Should never reach here based on problem constraints
        return new int[]{-1, -1};
    }
}

