package MyDSA.recursion.questions;

public class OccurancesFind {
    public static void findOccurances(int[] arr,int target,int idx){
        if(idx < 0){
            return;
        }
        findOccurances(arr,target,idx-1);

        if(arr[idx] == target){
            System.out.print(idx);
        }
    }

    public static void main(String[] args) {

        findOccurances(new int[]{3,2,4,5,6,2,7,2,2},2,8);
    }
}
