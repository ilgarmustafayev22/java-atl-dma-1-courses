package az.atl;

import org.springframework.context.annotation.Primary;


public class Mazda implements Car{

    @Override
    public void startCar() {
        System.out.println("mazda");
    }

}
