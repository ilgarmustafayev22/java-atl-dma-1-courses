package az.atlacademy.module03.lesson64;

public class Test implements Foo {

    public void foo() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Foo test = new Test2();
        test.foo();

        Test2 test2 = new Test2();
        test2.foo();

    }


}

class Test2 implements Foo {

    public void foo() {
        System.out.println("test2");
    }

}


interface Foo {

    void foo();

}