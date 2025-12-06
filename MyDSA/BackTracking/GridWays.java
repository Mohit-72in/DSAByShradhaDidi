package MyDSA.BackTracking;

public class GridWays { //t.c = O(2^(m+n))
    public static int findGridWays(int i,int j,int m,int n){
        if(i == m-1 && j == n-1){
            return 1;
        } else if (i==m || j == n) {
            return 0;
        }
        int downWays = findGridWays(i+1,j,m,n);
        int rightWays = findGridWays(i,j+1,m,n);
        return downWays+rightWays;
    }

    public static void main(String[] args) {
        int m = 5,n = 5;
        System.out.println(findGridWays(0,0,m,n));//70
    }
}

// Math Trick to find Total No of ways
/* totalWays = ((n-1)+(m-1))! /((n-1)! * (m-1)!)
for n = 3,m=3
totalWays = 4!/(2!*2!) = 6ways
 */
