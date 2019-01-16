package service;

import domain.HygieneProduct;
import domain.Parrot;
import domain.ParrotStats;

import java.util.List;
import java.util.Set;

public interface ParrotManager {
    List<Parrot> getAllParrots();
    void addParrot(Parrot parrot);
    Parrot getParrot(int id);
    void removeParrot(int id);
    Parrot getParrotByName(String parrotName);
    void removeParrotByName(String parrotName);
    List<Parrot> getAllExoticParrots();
    ParrotStats getParrotStats(String parrotName);
    Set<HygieneProduct> getAllParrotHygieneProducts(String parrotName);
}
