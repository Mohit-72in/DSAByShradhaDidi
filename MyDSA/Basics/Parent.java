package MyDSA.Basics;

public class Parent {
    int a = 10;
}
class B extends Parent{
    int a = 15;
}
class Main{
    public static void main(String[] args) {
        Parent b = new B();
        System.out.println(b.a);
    }
}
