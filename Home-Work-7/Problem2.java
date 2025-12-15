class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 2)
                    q.offer(new int[]{row,col,0});
                else if(grid[row][col] == 1)
                    fresh++;
            }
        }

        int time = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            for(int d[] : directions){
                int nr = r + d[0];
                int nc = c + d[1];
                time = t;

                if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc, t+1});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? time : -1;
        
        
    }
}