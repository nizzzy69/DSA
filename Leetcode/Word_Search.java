class Solution {
    public boolean exist(char[][] board, String word) {
        int R=board.length;
        int C=board[0].length;
        boolean visted[][] = new boolean[R][C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]==word.charAt(0)){
                    if(dfs(board,word,R,C,row,col,word.length(),0,visted)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int R,int C,int row,int col,int N,int i,boolean[][] visted){
        if(N==i) return true;
        if(row>=R||row<0||col>=C||col<0||visted[row][col]||board[row][col]!=word.charAt(i)) return false;
        visted[row][col] = true;
        boolean flag = false;
        flag |= dfs(board,word,R,C,row,col-1,N,i+1,visted);
        flag |= dfs(board,word,R,C,row-1,col,N,i+1,visted);
        flag |= dfs(board,word,R,C,row,col+1,N,i+1,visted);
        flag |= dfs(board,word,R,C,row+1,col,N,i+1,visted);
        visted[row][col]=false;
        return flag;       
    }
}
