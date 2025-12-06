package MyDSA.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        void push(int data){
            deque.addLast(data);
        }
        int pop(){
            return deque.removeLast();
        }
        int peek(){
            return deque.getLast();
        }
        boolean isEmpty(){
            return deque.isEmpty();
        }
    }

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
        public boolean isEmpty(){
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println("Top of Stack : "+s.peek());
//        while(!s.isEmpty()){
//            System.out.println(s.pop());
//        }
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Top of Stack : "+q.peek());
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
