package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Arrays;
import java.util.HashMap;

//Two Sum II - Input Array Is Sorted
//Find indices of two numbers in a sorted array that add up to a target.
//        Explanation: We use two pointers starting at both ends. If the sum is too small,
//move left. If too big, move right. Stop when the sum equals target.
//Input:  2  7  11  15  20
//        9
//Output:  1 , 2
public class TwoSum {
    public static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        for(int i = 0;i<len;i++){
            int comp = target-arr[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i+1};
            }else{
                map.put(arr[i],i+1);
            }
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15,20};
        int target = 27;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
}
