package done;

public class MaxAreaOfIsland {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0 | grid[0].length==0)return 0;
        help(grid);
        return max;
    }
    
    public void help(int[][]g){
        for(int i=0;i<g.length;++i){
            for(int j=0;j<g[0].length;++j){
                if(g[i][j]==1){
                    max = Math.max(max,area(i,j,g));
                }
            }
        }
    }
    
    public int area(int i, int j, int[][]g){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j]==0)return 0;
        g[i][j]=0;
        return 1 + area(i+1, j, g) + area(i-1, j,g) + area(i, j+1,g) + area(i, j-1,g);
    }
}
