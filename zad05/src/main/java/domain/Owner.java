package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Parrot> parrots = new ArrayList<>();


    public Owner() {}

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Owner(String firstName, String lastName, List<Parrot> parrots) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parrots = parrots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Parrot> getParrots() {
        return parrots;
    }

    public void setParrots(List<Parrot> parrots) {
        this.parrots = parrots;
    }
}
