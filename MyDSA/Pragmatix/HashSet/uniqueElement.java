package MyDSA.Pragmatix.HashSet;

import javax.swing.plaf.IconUIResource;

public class uniqueElement {
    public static String Unique(String s){
        int arr[] = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(arr[ch-'a']>1 || arr[ch-'a'] == 0){
                continue;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabaacd";
        System.out.println(Unique(s));
    }
}
