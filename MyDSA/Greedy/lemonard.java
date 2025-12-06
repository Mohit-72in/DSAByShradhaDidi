package MyDSA.Greedy;

public class lemonard {
    public static boolean isWeReturnCoin(int[] arr){
        int five = 0,ten = 0;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] == 5){
                five++;
            }else if(arr[i] == 10){
                if(five>0){
                    ten++;
                    five--;
                }else return false;
            }else{ // if customer give 20rs note
                if(ten>0 && five > 0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five -= 3;
                }else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int coins[] = {5,5,10,5,20,10,20};
        System.out.println(isWeReturnCoin(coins));
    }
}
