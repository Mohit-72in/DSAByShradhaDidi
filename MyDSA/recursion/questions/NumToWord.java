package MyDSA.recursion.questions;

import java.util.HashMap;

public class NumToWord {
    HashMap<Integer,String> hm;
    public NumToWord(){
        hm = new HashMap<>();
        hm.put(0,"Zero");
        hm.put(1,"One");
        hm.put(2,"Two");
        hm.put(3,"Three");
        hm.put(4,"Four");
        hm.put(5,"Five");
        hm.put(6,"Six");
        hm.put(7,"Seven");
        hm.put(8,"Eight");
        hm.put(9,"Nine");

    }


    public static void NumToWordChange(int num,HashMap<Integer,String> hm){
        if(num == 0){
            return;
        }
        NumToWordChange(num/10,hm);
        System.out.print(hm.get(num%10)+" ");
    }

    public static void main(String[] args) {
        NumToWord obj = new NumToWord();
        NumToWordChange(24100335,obj.hm);
    }
}
