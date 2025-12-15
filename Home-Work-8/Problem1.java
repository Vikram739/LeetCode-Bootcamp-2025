class Solution {

    private boolean solve(int index, int[] nums, int dp[][], int target){

        if(target == 0)
            return true;
        
        if(index == 0) 
            return nums[0] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;

        boolean notTaken = solve(index-1,nums,dp,target);

        boolean taken = false;
        if(nums[index] <= target)
            taken = solve(index-1,nums,dp,target-nums[index]);

        dp[index][target] = taken || notTaken ? 1 : 0;
        return taken || notTaken;
    }

    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
        }

        if(sum % 2 != 0)
            return false;
        
        int s = sum/2;
        int dp[][] = new int[n][s+1];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(n-1,nums,dp,s);

    }
}