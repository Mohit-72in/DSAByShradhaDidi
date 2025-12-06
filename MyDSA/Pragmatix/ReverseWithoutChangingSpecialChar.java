package MyDSA.Pragmatix;

public class ReverseWithoutChangingSpecialChar {

    public String swapAlpha(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(arr[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(arr[j])) {
                j--;
            } else {
                // Swap letters/digits
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseWithoutChangingSpecialChar ob = new ReverseWithoutChangingSpecialChar();
        String input = "St@ud&e#nt";
        System.out.println("Original: " + input);
        String result = ob.swapAlpha(input);
        System.out.println("Reversed: " + result);
    }
}
