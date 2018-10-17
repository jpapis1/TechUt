package app.domain;

public class Parrot {
    private String latinName;
    private String givenName;
    private int age;
    private String countryOfOrigin;

    public Parrot(String latinName, String givenName, int age, String countryOfOrigin) {
        this.latinName = latinName;
        this.givenName = givenName;
        this.age = age;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
