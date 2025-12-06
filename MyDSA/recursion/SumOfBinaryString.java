package MyDSA.recursion;

public class SumOfBinaryString {
    public static void main(String[] args) {
        System.out.println(binaryStringSum("10110000000000000110101010101011010101","100"));
        System.out.println(binaryStringSum("1111","100"));

    }
    public static String binaryStringSum(String s1, String s2){
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        sb2.reverse();
        s1 = sb1.toString();
        s2 = sb2.toString();
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0,j = 0;
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i<len1 || j < len2 || carry!= 0){
            int ch1 = (i<len1)?s1.charAt(i)-'0' : 0;
            int ch2 = (j<len2)?s2.charAt(j)-'0' : 0;
            sum = ch1 + ch2 + carry;
            sb.append(sum%2);
            carry = sum/2;
            i++;
            j++;
        }
        return sb.reverse().toString();


    }

}

