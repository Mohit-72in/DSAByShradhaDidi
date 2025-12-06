package MyDSA.Greedy;

import java.util.ArrayList;

public class ActivitySelectionPrblm {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        int maxActivity = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        maxActivity = 1;
        int endTime = end[0];
        int i = 1;
        while(i<end.length){
            if(start[i]>= endTime){
                maxActivity++;
                arr.add(i);
                endTime = end[i];
            }
            i++;
        }
        System.out.println("MaxActivity done: "+maxActivity);
        for(int j : arr){
            System.out.print(j + " ");
        }
    }
}
