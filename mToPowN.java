//public class mToPowN {
//    public static void main(String[] args) {
//        // m ^ n
//        int m = 9 , n = 13;
//        long midresult = mToN(m,n/2);
//        if(n%2==0){
//            long ans = midresult*midresult;
//            System.out.println(ans);
//        }else {
//            long ans = midresult*midresult*m;
//            System.out.println(ans+" odd n");
//        }
//
//
//    }
//    public static long mToN(int m,int n){
//        if(n == 0) return 1;
//        return m*mToN(m,n-1);
//    }
//
//}
public class mToPowN {
    public static double myPowerFunc(int m, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            return 1.0 / myPowerFunc(m, -n);
        }

        if (n % 2 == 0) {
            double half = myPowerFunc(m, n / 2);
            return half * half;
        } else {
            double half = myPowerFunc(m, n / 2);
            return m * half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPowerFunc(-5, 2));   // 25.0
        System.out.println(myPowerFunc(5, -5));  // 3.2E-4 (≈ 0.00032)
        System.out.println(myPowerFunc(5, 3));   // 125.0
    }
}
