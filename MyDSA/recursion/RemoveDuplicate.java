package MyDSA.recursion;

public class RemoveDuplicate {
    private static boolean[] arr = new boolean[26];
    public static String UniqueCharStr(String s){
        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray()){
            int idx = x-'a';
            if(!arr[idx]){
                sb.append(x);
                arr[idx] = true;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(UniqueCharStr("appnnacollege"));
    }


}
