
public class nqueens {
    static boolean isSafe(int[][] board, int row, int col){
        int N = board.length;
        for(int i=0; i<col; i++){                                         
            if(board[row][i] == 1){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){            
            if(board[i][j] == 1){
                return false;
            }
        }
        for(int i = row, j = col; i < N && j >= N; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    static boolean solve(int[][] board, int col){
        int N = board.length;
        if(col >= N){
            return true;
        }
        for(int i=0; i<N; i++){
            if(isSafe(board, i, col)){
                board[i][col] = 1;
                if(solve(board, col+1) == true){
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    static void printBoard(int[][] board){
        int N = board.length;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        solve(board, 0);
        printBoard(board);
    }
}
