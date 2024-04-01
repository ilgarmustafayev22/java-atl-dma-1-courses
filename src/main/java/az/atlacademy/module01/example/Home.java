package az.atlacademy.module01.example;

import java.util.Objects;

public class Home {
    public String door;

    public Home(String door) {
        this.door = door;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(door, home.door);
    }

    @Override
    public int hashCode() {
        return Objects.hash(door);
    }

    @Override
    public String toString() {
        return "Home{" +
                "door='" + door + '\'' +
                '}';
    }

}
