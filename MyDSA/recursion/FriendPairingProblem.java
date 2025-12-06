package MyDSA.recursion;

public class FriendPairingProblem {
    public static int NoOfPairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int singleWays = NoOfPairs(n-1);
        int inPairWays = (n-1)*NoOfPairs(n-2);
        return singleWays+inPairWays;
    }

    public static void main(String[] args) {
        System.out.println("Total No Of Ways Of Pairing : "+NoOfPairs(3));
        System.out.println("Total No Of Ways Of Pairing : "+NoOfPairs(10));

    }
}
