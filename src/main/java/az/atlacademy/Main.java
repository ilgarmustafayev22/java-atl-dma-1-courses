package az.atlacademy;

public class Main {
    public static void main(String[] args) {
        String x = "Hello World";
        String y = " Hello World".trim();
        String z = "Hello World".toString();

        System.out.println(x == y);
        System.out.println(x == z);

        System.out.println(x.equals(y));
        System.out.println(x.equals(z));

    }

}