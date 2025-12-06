package MyDSA.Pragmatix.HashSet;

import java.util.Scanner;

public class PasswordChecker {
    public static void isValidPwd(String s){
        int len = s.trim().length();
        boolean l = false;
        boolean num= false;
        boolean lower = false;
        boolean upper = false;
        boolean special = false;
        String specialArr = "&*# $;_";
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)) lower = true;
            if(Character.isUpperCase(ch)) upper = true;
            if(Character.isDigit(ch)) num = true;
            if(specialArr.contains(String.valueOf(ch))) special = true;
            if(len>=8) l = true;
        }
        if(l && special && num && lower && upper ){
            System.out.println("Valid Password: "+ s.trim());
        }else{
            System.out.println("Invalid");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        isValidPwd(s);
    }
}
