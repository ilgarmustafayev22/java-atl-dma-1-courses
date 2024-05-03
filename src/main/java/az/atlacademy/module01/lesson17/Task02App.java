package az.atlacademy.module01.lesson17;

public class Task02App {

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
    }

    public static int sum(int k) {

        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }

    }

}
