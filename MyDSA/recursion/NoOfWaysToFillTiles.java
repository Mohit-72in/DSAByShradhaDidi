package MyDSA.recursion;

public class NoOfWaysToFillTiles {
    public static void main(String[] args) {
        System.out.println(findWays(3));
    }
    public static int findWays(int n){
        if(n <2) return 1;
        if(n == 2) return 2;
        return findWays(n-1)+findWays(n-2);
    }
}
