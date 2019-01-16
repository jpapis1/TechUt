package domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name="Parrot.all", query="SELECT p FROM Parrot p"),
        @NamedQuery(name="Parrot.exotic", query="SELECT p FROM Parrot p WHERE isExotic=true"),
        @NamedQuery(name="Parrot.byName", query="SELECT p FROM Parrot p WHERE p.name = :name"),
        @NamedQuery(name="Parrot.getOwners", query="SELECT o FROM Owner o WHERE o.firstName = :firstName AND o.lastName = :lastName")
})


@Entity
public class Parrot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateOfBirth;
    private double weight;
    private boolean isExotic;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Country country;
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ParrotStats stats;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="HYGIENEPRODUCT_PARROT", joinColumns=@JoinColumn(name="Parrots_id"), inverseJoinColumns=@JoinColumn(name="products_id"))
    public Set<HygieneProduct> products;

    /*
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Parrot_Product",
            joinColumns = { @JoinColumn(name = "parrot_id") },
            inverseJoinColumns = { @JoinColumn(name = "hygiene_product_id") }
    )
    private Set<HygieneProduct> products = new HashSet<>();*/

    public Parrot() {}
    public Parrot(String name, Date dateOfBirth, double weight, boolean isExotic, Country country, ParrotStats stats) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.isExotic = isExotic;
        this.country = country;
        this.stats = stats;
    }
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

    public Set<HygieneProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<HygieneProduct> products) {
        this.products = products;
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