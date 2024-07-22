import az.atl.JavaConfiguration;
import az.atl.ServiceCar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
         new AnnotationConfigApplicationContext(JavaConfiguration.class)
                 .getBean("serviceCar", ServiceCar.class)
                 .callCar();
    }

}