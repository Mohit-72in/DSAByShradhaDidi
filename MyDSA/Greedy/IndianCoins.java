package MyDSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] coins = {2000,500,1,2,5,10,50,100,20};
        int amt = 590;
        Arrays.sort(coins, Comparator.reverseOrder());

        int cntOfCoins = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<coins.length;i++){
            if(coins[i]<=amt){
                while(coins[i]<=amt){
                    amt -= coins[i];
                    arr.add(coins[i]);
                    cntOfCoins++;
                }
            }
        }
        System.out.println("Total Min Coins Used = "+cntOfCoins);
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
