package az.atlacademy.module01.example02;

public class CarApp {

    public static void main(String[] args) {
        Car car = new Car("black", "4.4", 4);
        System.out.println(car);
        car.foo();

      // Car car1 = new Car();
      // car1.setColor("green");
      // car1.setWheel(5);
      // car1.setEngine("6.3");
      // System.out.println(car1);
      // car1.toString();

      // int wheel = car.getWheel();
      // String color = car.getColor();
      // System.out.println(color);

      // car.setColor("yellow");
      // System.out.println(car);

      // String color1 = car.getColor();
      // System.out.println(color1);

    }

}
