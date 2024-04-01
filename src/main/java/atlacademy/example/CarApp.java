package atlacademy.example;

public class CarApp {

    public static void main(String[] args) {

        String car1 = new String("Car");
        String car2 = new String("Car");
        String car3 = "Car";
        String car4 = "Car";
        int num = 1;
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        System.out.println(car4.hashCode());

        System.out.println(car1.equals(car2));
        System.out.println(car1 == car2);

        //Scanner sc = new Scanner(System.in);
        //int wheel = sc.nextInt();
        //String color = sc.next();
        //String engine = sc.next();

        Car car = new Car("4.4", "black", 4);
        // Car car2 = new Car("5.5", "black", 2);
        // Car car3 = new Car("4.4", "black", 4);


        // System.out.println(car);
        // System.out.println(car.equals(car2));
        // System.out.println(car.hashCode());
        // System.out.println(car2.hashCode());
        // System.out.println(car3.hashCode());

        // Home home = new Home("door");
        // System.out.println(home);
        // System.out.println(home.equals(car));
        // System.out.println(home.hashCode());

        //Car car = new Car("5,5", "black", 4);
        //System.out.println(car);
        //Car car2 = new Car("4.4");

        //Car car1 = new Car();

    }

}
