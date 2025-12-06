package MyDSA.Pragmatix.TwoThreePointer;

import java.util.Scanner;

public class ValidPalindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        while (t-- > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            ob.isValidPalindrom(s);
        }
    }
}

class Solution {
    public void isValidPalindrom(String s) {
//        int left = 0,right = s.length()-1;
//        while(left<right){
//            while(left<right && Character.isLetterOrDigit(s.charAt(left))){
//                ch = Character.toLowerCase(ch)
//            }
//
//        }
//
//    }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        if (isPalindrom(sb.toString())) {
            System.out.printf("%s is a Valid Palindrome\n", s);
        } else {
            System.out.printf("%s is an Invalid Palindrome\n", s);
        }
    }

    public boolean isPalindrom(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
