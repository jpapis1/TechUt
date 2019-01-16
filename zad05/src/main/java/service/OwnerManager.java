package service;

import domain.Owner;
import domain.Parrot;

import java.util.List;

public interface OwnerManager {
    List<Parrot> getOwnersParrots(String firstName, String lastName);
    void addOwner(Owner owner);
}
