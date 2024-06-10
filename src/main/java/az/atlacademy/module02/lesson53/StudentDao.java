package az.atlacademy.module02.lesson53;

import java.util.Optional;

public interface StudentDao <E>{

    Optional<E> findByName(String name);

}
