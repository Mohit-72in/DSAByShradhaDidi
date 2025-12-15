package MyDSA.Pragmatix.HashMap;

import java.util.HashMap;

public class SubArray0Sum {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        // output = {-2,2,-8,1,7} len = 5
        HashMap<Integer,Integer> map = new HashMap<>();
        //declare 2 variable length to track maxLength and prefix sum
        int sum =0;
        int len = 0;
        for(int j = 0;j< arr.length;j++){
            sum += arr[j];
            //check if sum already  exist in the map --> sum(i+1,j) = sum(0,j) - sum(0,i)
            if(map.containsKey(sum)){
                len = Math.max(len,(j-map.get(sum)));
            }else{
                map.put(sum,j);
            }
        }
        System.out.println("SubArray with sum 0 has length = "+len);
    }
}
