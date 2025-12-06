package MyDSA.Pragmatix.HashSet;

import java.util.ArrayList;
import java.util.Scanner;

public class AbundenNum {
    public static boolean isAbundent(int num){
        ArrayList<Integer> a= new ArrayList<>();
        for(int i = 2;i<=num/2;i++){
            if(num%i == 0){
                a.add(i);
            }
        }
        return getSum(a)>num;
    }
    public static int getSum(ArrayList<Integer> a ){
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num: ");
        int num = sc.nextInt();
        System.out.println("Num : "+num+" is : abundent or not: "+isAbundent(num));


    }
}
