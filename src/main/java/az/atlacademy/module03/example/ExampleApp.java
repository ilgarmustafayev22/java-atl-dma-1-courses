package az.atlacademy.module03.example;

public class ExampleApp {

   static TestInterface testInterface;

    public ExampleApp(TestInterface testInterface) {
        this.testInterface = testInterface;
    }

    public  void main() {
        testInterface.doSome();
    }


}

interface TestInterface{
    void doSome();
}
class Test implements TestInterface{

    @Override
    public void doSome(){
        System.out.printf("dosome");
    }
}

class Test2 implements TestInterface{

    @Override
    public void  doSome(){
        System.out.printf("some");
    }

}
