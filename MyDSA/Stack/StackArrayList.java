package MyDSA.Stack;

import java.util.ArrayList;

public class StackArrayList {
    static class Stack{
        static ArrayList<Integer> s = new ArrayList<>();
        public static boolean isEmpty(){
            return s.size() == 0;
        }
        //push
        public static void push(int data){
            s.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int popped = s.get(s.size()-1);
            s.remove(s.size()-1);
            return popped;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return s.get(s.size()-1);
        }

        public static void main(String[] args) {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);

            while (!s.isEmpty()){
                System.out.println(s.peek());
                s.pop();
            }
        }


    }
}
