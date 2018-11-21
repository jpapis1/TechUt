package domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Parrot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateOfBirth;
    private double weight;
    private boolean isExotic;
    @ManyToOne
    private Country country;
    @OneToOne
    private ParrotStats stats;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Parrot_Product",
            joinColumns = { @JoinColumn(name = "parrot_id") },
            inverseJoinColumns = { @JoinColumn(name = "hygiene_product_id") }
    )
    Set<HygieneProduct> products = new HashSet<>();

    public Parrot() {}
    public Parrot(String name, Date dateOfBirth, double weight, boolean isExotic) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.isExotic = isExotic;
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

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isExotic() {
        return isExotic;
    }

    public void setExotic(boolean exotic) {
        isExotic = exotic;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ParrotStats getStats() {
        return stats;
    }

    public void setStats(ParrotStats stats) {
        this.stats = stats;
    }


    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                ", isExotic=" + isExotic +
                '}';
    }
}