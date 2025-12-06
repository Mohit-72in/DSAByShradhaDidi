package MyDSA.Pragmatix.TwoThreePointer;
/*
Question: Calculate how much water can be trapped between bars of different
heights.
Explanation: Use two pointers to track left and right max height. Accumulate
water where current height is less than max.

Input : 0 1 0 2 1 0 1 3 2 1 2 1
Output :  6
*/
public class TrappingRainWater {
    public int TrappedWater(int[] arr){
        int len = arr.length;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        int maxStored = 0;
        left(arr,leftArr);
        right(arr,rightArr);
        for(int i = 0;i<len;i++){
            int minHeight = Math.min(leftArr[i],rightArr[i]);
            maxStored += (minHeight-arr[i]);
        }
        return maxStored;


    }
    public void left(int[] arr,int[] left){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            int newmax = 0;
            for(int j = i;j<n;j++){
                newmax = Math.max(newmax,arr[j]);
            }
            left[i] = newmax;
        }
    }

    public void right(int[] arr,int[] right){
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            int newmax = 0;
            for(int j = i;j>=0;j--){
                newmax = Math.max(newmax,arr[j]);
            }
            right[i] = newmax;
        }
    }
}
class TrapWater{
    public static void main(String[] args) {
        TrappingRainWater ob = new TrappingRainWater();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int maxContain = ob.TrappedWater(arr);
        System.out.println("MaxWater Collected: "+maxContain);
    }
}
