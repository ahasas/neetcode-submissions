class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null)return ;
        int row=grid.length, col=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0)q.offer(new int[]{i,j});
            }
        }
        if(q.isEmpty())return ;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int [] temp=q.poll();
                for(int[] d:dir){
                    int dx=d[0]+temp[0];
                    int dy=d[1]+temp[1];
                    if(dx<0||dy<0||dx>=row||dy>=col||grid[dx][dy]!=Integer.MAX_VALUE)continue;
                    grid[dx][dy]=grid[temp[0]][temp[1]]+1;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        return;
        
    }
}
