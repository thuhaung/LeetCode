package Math;

public class Pow {
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0 || x == 1 || n == 1) return x;

        double res = 1;
        long i = Math.abs((long) n);

        while (i > 0) {
            System.out.println("at i = " + i);
            if (i % 2 == 0) {
                x *= x;
                i /= 2;
            }
            else {
                res *= x;
                i--;
            }

            System.out.println("res = " + res + ", x = " + x);
        }

        return (n < 0) ? 1 / res : res;
    }

    public static void main(String[] args) {
        pow(2, -2147483648);
    }
}
