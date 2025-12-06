package MyDSA.BackTracking;

public class FindPermutations {
    public static void findPermutation(String str,String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i = 0;i<str.length();i++){
            char curr = str.charAt(i);
            // "abcde" remove c => "ab" + "de"
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newStr,ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "MohitYadav";
        findPermutation(str,"");
    }


}
