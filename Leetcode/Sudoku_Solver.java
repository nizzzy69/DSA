class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.'){
                    int dig = board[row][col]-'0';
                    rows[row][dig]=true;
                    cols[col][dig]=true;
                    int bi = (row/3)*3+(col/3);
                    boxes[bi][dig] = true;
                }
            }
        }
        helper(board,rows,cols,boxes,0,0);
    }

    private boolean helper(char[][] board,boolean[][] rows,boolean[][] cols,boolean[][] boxes,int r,int c){
        if(c==9){
            c=0;
            r++;
        }
        if(r>=9) return true;
        if(board[r][c]=='.'){
            for(int n=1;n<=9;n++){
                if(!rows[r][n]&&!cols[c][n]&&!boxes[((r/3)*3)+(c/3)][n]){
                    rows[r][n]=true;
                    cols[c][n]=true;
                    boxes[((r/3)*3)+(c/3)][n]=true;
                    board[r][c] = (char)('0'+n);
                    if(helper(board,rows,cols,boxes,r,c+1)) return true;
                    rows[r][n]=false;
                    cols[c][n]=false;
                    boxes[((r/3)*3)+(c/3)][n]=false;
                    board[r][c]='.';
                }
            }
        }
        else return helper(board,rows,cols,boxes,r,c+1);
        return false;
    }
}
