package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name="Product.byName", query="SELECT p FROM HygieneProduct p WHERE p.name = :name")

})

@Entity
public class HygieneProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;


    @ManyToMany(mappedBy = "products", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Parrot> parrots;

    public HygieneProduct() {}
    public HygieneProduct(String name) {
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Parrot> getParrots() {
        return parrots;
    }

    public void setParrots(Set<Parrot> parrots) {
        this.parrots = parrots;
    }
}
