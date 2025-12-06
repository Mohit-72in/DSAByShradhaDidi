package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Arrays;

public class RangePrime {
    public static int countPrime(int lb,int ub){
        boolean[] primes = new boolean[1001];
        Arrays.fill(primes,true);
        primes[0] = primes[1] = false;
        for(int i = 2;i*i<1001;i++){
            if(primes[i]){
                for(int j = i*i;j<1001;j = j+i){
                    primes[j] = false;
                }
            }

        }
        int count = 0;
        for(int i = lb;i<=ub;i++){
            if(primes[i]){
                count++;

            }
        }
        return count;


    }

    public static void main(String[] args) {
        int lb = 1;
        int ub = 10;
        System.out.println("Primes count:"+countPrime(lb,ub));
    }
}
