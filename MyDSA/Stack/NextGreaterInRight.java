package MyDSA.Stack;

import javax.swing.*;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterInRight {
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int n = arr.length;
        int nextGreater[] = new int[n];
        int nextSmaller[] = new int[n];
        nextGreaterFind(arr,nextGreater);
        System.out.println(Arrays.toString(nextGreater));
        nextGreaterInLeft(arr,nextGreater);
        System.out.println(Arrays.toString(nextGreater));
        nextSmallerInLeft(arr,nextSmaller);
        System.out.println(Arrays.toString(nextSmaller));
        nextSmallerInRight(arr,nextSmaller);
        System.out.println(Arrays.toString(nextSmaller));
    }

    private static void nextSmallerInRight(int[] arr, int[] nextSmaller) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller[i] = -1;
            }else {
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    private static void nextSmallerInLeft(int[] arr, int[] nextSmaller) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i = 0;i<n;i++){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller[i] = -1;
            }else {
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void nextGreaterFind(int[] arr,int[] nextGreater){
        //1.while
        int n = arr.length;
        Stack<Integer> s = new Stack<>();

        for(int i = n-1;i>=0;i-- ){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){  // O(2n)
                s.pop();
            }
            // 2 if else
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else {
                nextGreater[i] = arr[s.peek()];
            }
            // push element
            s.push(i);
        }
    }
    public static void nextGreaterInLeft(int[] arr,int[] nextGreater){
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i = 0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }

    }
}
