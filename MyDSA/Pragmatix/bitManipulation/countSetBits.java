package MyDSA.Pragmatix.bitManipulation;

import java.util.Scanner;

public class countSetBits {
    public static int countSetBit(int n){
        int count = 0;

        for(int i = 0;i<32;i++){
            int mask = 1<<i;
            if((n&mask) != 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of TestCases: ");
        int t = sc.nextInt();
        while (t-->0){
            System.out.print("Enter Number: ");
            int n = sc.nextInt();
            System.out.println("Num of Set Bits: "+countSetBit(n));

        }
    }
}
