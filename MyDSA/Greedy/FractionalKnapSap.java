package MyDSA.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSap {

    public static void main(String[] args) {
        int wt[] = {10,20,30};
        int val[] = {60,100,120};
        int capacity = 50;

        int[][] rate = new int[wt.length][wt.length];
        for(int i = 0;i<wt.length;i++){
            rate[i][0] = i;
            rate[i][1] = val[i]/wt[i];
        }

        Arrays.sort(rate, Comparator.comparingDouble(o->o[1]));
        int totSum = 0;
        int i = 0;
//        while(capacity>0){
//            int idx = rate[i][0];
//            if(capacity>wt[idx]){
//                totSum += rate[i][1]*wt[idx];
//                capacity -= wt[idx];
//                i++;
//            }else{
//                totSum += rate[idx][1]*capacity;
//                break;
//            }

        for( i = wt.length-1;i>=0;i--){
            int idx = rate[i][0];
            if(capacity>=wt[idx]){
                totSum += val[idx];
                capacity -= wt[idx];
            }else{
                totSum += rate[i][1]*capacity;
                capacity = 0;
                break;
            }


        }
        System.out.println("Max Sum : "+totSum);


    }
}
