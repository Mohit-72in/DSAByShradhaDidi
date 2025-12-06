package MyDSA.Pragmatix.bitManipulation;

import java.util.Scanner;

public class ChorPolish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num Of TestCases: ");
        int t = sc.nextInt();
        while (t-->0){
            System.out.println("Enter Size Of Array: ");
            int n = sc.nextInt();
            System.out.println("Enter Array Element: ");
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int crimeHappend = ChorPolishGame(arr);
            System.out.println("Total Crime Happened: "+crimeHappend);

        }

    }
    public static int ChorPolishGame(int[] arr){
        int totalCrime = 0;
        int policeCount = 0;
        for(int i:arr){
            if(i == -1 && policeCount == 0 ){
                totalCrime++;
            }else if(i == -1 && policeCount >0){
                policeCount--;
            }else if(i != -1){
                policeCount += i;
            }

        }
        return totalCrime;
    }
}
