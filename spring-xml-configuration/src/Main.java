import az.atl.ServiceCar;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-configuration.xml");
        ServiceCar serviceCar = applicationContext.getBean("ServiceCarImpl", ServiceCar.class);
        ServiceCar serviceCar2 = applicationContext.getBean("ServiceCarImpl2", ServiceCar.class);
        serviceCar.callCar();
        serviceCar2.callCar();

    }

}