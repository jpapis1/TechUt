package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class HygieneProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "products")
    private Set<Parrot> parrots = new HashSet<>();
    public HygieneProduct() {}

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
}
