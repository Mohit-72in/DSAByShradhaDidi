package MyDSA.BackTracking;

public class RatInMaze {
    public static boolean isSafe(int mat[][],int row,int col){
        return (row>=0 && row<mat.length && col>=0 && col< mat.length && mat[row][col] == 1);
    }
    public static void printMaze(int mat[][]){
        int n = mat.length;
        for(int x[] :mat){
            for(int i : x){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void findPath(int mat[][]){
        int n = mat.length;
        int sol[][] = new int[n][n];
        if(!solveMazeUntil(mat,0,0,sol)){
            System.out.println("Solution Does Not Exist");
            return;
        }
        printMaze(sol);
        return;

    }
    public static boolean solveMazeUntil(int mat[][],int row,int col,int sol[][]){
        if(row == mat.length-1 && col == mat.length-1 && mat[row][col] == 1 ){
            sol[row][col] = 1;
            return true;
        }
        if(isSafe(mat, row, col)){
            if(sol[row][col] == 1){
                return false;
            }
            sol[row][col] = 1;
            if(solveMazeUntil(mat,row+1,col,sol)){
                return true;
            }
            if(solveMazeUntil(mat,row,col+1,sol)){
                return true;
            }
            sol[row][col] = 0;
            return false;

        }
        return false;

    }
    public static void main(String args[]) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };

        findPath(maze);
    }

}
