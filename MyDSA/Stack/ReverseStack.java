package MyDSA.Stack;
import MyDSA.Stack.*;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);

    }

    private static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        int data = s.pop();
        reverseStack(s);
        PushAtBottom.pushAtBottom(s,data);
    }
}

