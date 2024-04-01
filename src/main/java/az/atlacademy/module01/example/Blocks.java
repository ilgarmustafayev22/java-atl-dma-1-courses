package az.atlacademy.module01.example;

public class Blocks {
    static  {
        System.out.println("In static block");
    }

    {
        System.out.println("in non static (instance)  ");
    }

    public  static  void  foo(){
        System.out.println("In static method");
    }
}