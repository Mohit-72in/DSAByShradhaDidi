public class recursion {
    public static void main(String[] args) {
        //first ocurance 6 6 3 4 2 --> 1;
        System.out.println(firstOccurances(new int[]{6,6,3,4,2},6,4));

    }
    public static int firstOccurances(int []arr,int target,int i){
        if(i == -1){
            return -1;
        }
        if(arr[i]==target ){
            return i+1;
        }
        return firstOccurances(arr,target,i-1);
    }
}
