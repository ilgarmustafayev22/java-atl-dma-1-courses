package az.atlacademy.module01.lesson01;

public class StringExampleApp {

    public static void main(String[] args) {

        String alma1 = new String("Alma");
        String alma = "Alma";
        String alma2 = "Alma";
        String alma211 = new String("Alma");
        System.out.println(alma.hashCode());
        System.out.println(alma2.hashCode());
        System.out.println(alma211.hashCode());
        boolean b = alma == alma1;
        boolean equals = alma.equals(alma1);

        System.out.println(b);
        System.out.println(equals);

    }

}
