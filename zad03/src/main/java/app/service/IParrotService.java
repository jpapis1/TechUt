package app.service;

import app.domain.Parrot;

import java.util.List;

public interface IParrotService {
    public boolean addParrot(Parrot parrot);
    public boolean deleteParrot(String parrotName);

    public boolean addListOfParrots(List<Parrot> parrotList);
    public List<Parrot> getAllParrots();
    public void printAllParrots();

    public List<Parrot> getExoticParrots();
    public Parrot getTheOldestParrot();

}
