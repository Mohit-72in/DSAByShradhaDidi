package MyDSA.Pragmatix.HashSet;

import java.util.Arrays;
import java.util.HashMap;

public class LHS {
    public int findLHS(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i: arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int maxSum = 0;
        for(int key : hm.keySet()){
            if(hm.containsKey(key+1)){
                maxSum = Math.max(maxSum,hm.get(key)+hm.get(key+1));
            }
        }
        return maxSum;
    }
}
class slove1 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 2, 5, 2, 3, 7};
        LHS ob = new LHS();
        int val = ob.findLHS(arr);
        System.out.println("LHS of " + Arrays.toString(arr) + " : " + val);
    }
}
