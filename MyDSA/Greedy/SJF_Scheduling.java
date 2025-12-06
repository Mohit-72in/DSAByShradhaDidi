package MyDSA.Greedy;

import java.util.Arrays;

public class SJF_Scheduling {
    public static int sjf(int[] bt){
        Arrays.sort(bt);
        int t = 0;
        int wt = 0;
        for(int x:bt){
            wt += t;
            t += x;
        }
        return wt;
    }

    public static void main(String[] args) {
        int[] bt = {4,2,1,5,6,1,2,1};
        System.out.println("sjf will take time: "+sjf(bt));
    }
}
