package MyDSA.Pragmatix.HashMap;
import java.util.*;
public class SubArraySumK {
    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        int k = -10;

        // output = {10,2,-2,-20},{-20,10}; {2,-2,-20,10} these subarray have sum = k
        HashMap<Integer,Integer> map = new HashMap<>();
        // note important to add map.put(sum:0,count:1) if subarray sum - k == 0 then map gives null so to prevent add (0,1)
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        // funda to solve --> sum(0,j) - sum(0,i-1) = sum(i,j) => sum(j) - sum(i) == k we have to find
        // search in map for {sum(j) - k == sum(i) } if exist in map
        for(int j = 0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);  // sum is present in map then add its count to ans denotes that much times sum encounter during traversing
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println("SubArraySum = "+k+" is encounter: "+ans+" no times");
    }
}
