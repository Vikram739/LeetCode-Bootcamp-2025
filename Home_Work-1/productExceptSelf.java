// OPTIMUM SOLUTION - O(n) time, O(1) space
class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Pass 1: Build prefix products (left to right)
        // answer[i] = product of all elements before index i
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        
        // Pass 2: Build suffix products and combine (right to left)
        // answer[i] *= product of all elements after index i
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        
        return answer;
    }
}

// Alternative solution with clearer visualization
class SolutionWithComments {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Step 1: Build prefix products
        // For nums = [1,2,3,4]
        // After this loop: answer = [1, 1, 2, 6]
        // answer[i] = product of all nums[0..i-1]
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        
        // Step 2: Build suffix products and multiply
        // For nums = [1,2,3,4]
        // i=3: answer[3] = 6 * 1 = 6, suffix = 4
        // i=2: answer[2] = 2 * 4 = 8, suffix = 12
        // i=1: answer[1] = 1 * 12 = 12, suffix = 24
        // i=0: answer[0] = 1 * 24 = 24, suffix = 24
        // Final: answer = [24, 12, 8, 6]
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        
        return answer;
    }
}
