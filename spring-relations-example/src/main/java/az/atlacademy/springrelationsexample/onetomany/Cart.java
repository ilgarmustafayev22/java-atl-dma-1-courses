package az.atlacademy.springrelationsexample.onetomany;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Item> items;

}
