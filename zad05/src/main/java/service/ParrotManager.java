package service;

import domain.Parrot;

import java.util.List;

public interface ParrotManager {
    List<Parrot> getAllParrots();
    void addParrot(Parrot parrot);
    void getParrot(int id);
}
