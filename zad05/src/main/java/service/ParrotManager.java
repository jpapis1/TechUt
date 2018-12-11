package service;

import domain.Parrot;

import java.util.List;

public interface ParrotManager {
    List<Parrot> getAllParrots();
    void addParrot(Parrot parrot);
    Parrot getParrot(int id);
    void removeParrot(int id);
    Parrot getParrotByName(String parrotName);
    void removeParrotByName(String parrotName);
    List<Parrot> getAllExoticParrots();
}
