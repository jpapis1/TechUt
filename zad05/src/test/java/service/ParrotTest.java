package service;

import domain.Country;
import domain.Parrot;
import domain.ParrotStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ParrotTest {
    @Autowired
    ParrotManager parrotManager;

    @Test
    public void addParrotTest() {
        generateData();

    }
    @Test
    public void showAllParrotsTest() {
        generateData();
        List<Parrot> allParrots = parrotManager.getAllParrots();
        System.out.println();
        System.out.println("SHOW ALL TEST");
        if(!allParrots.isEmpty()) {
            for(Parrot p : allParrots) {
                System.out.println(p.getName());
            }
        } else {
            System.out.println("Tablica papug pusta!");
        }
    }
    @Test
    public void showAllExoticParrotsTest() {
        generateData();
        List<Parrot> allParrots = parrotManager.getAllExoticParrots();
        System.out.println();
        System.out.println("SHOW ALL EXOTIC PARROTS TEST");

        if(!allParrots.isEmpty()) {
            for(Parrot p : allParrots) {
                System.out.println(p.getName());
            }
        } else {
            System.out.println("Tablica papug egzotycznych pusta!");
        }
    }


    @Test
    public void removeParrotTest() {
        Country country = new Country("New Zealand");
        ParrotStats stats = new ParrotStats("Kajetan",5,"czarny");
        Parrot parrot = new Parrot("Agapornis",new Date(),0.5,true,country,stats);
        parrotManager.addParrot(parrot);
        parrotManager.removeParrotByName("Agapornis");
    }

    @Test
    public void getParrotTest() {
        generateData();
        System.out.println("GET TEST: " + parrotManager.getParrotByName("Nimfa"));
    }

    public void generateData() {
        Country country = new Country("Australia");
        ParrotStats stats = new ParrotStats("Bury",3,"zielony");
        Parrot parrot = new Parrot("Nimfa",new Date(),0.3,true,country,stats);
        parrotManager.addParrot(parrot);
        country = new Country("USA");
        stats = new ParrotStats("Lexy",0,"brązowy");
        parrot = new Parrot("Strigopidae",new Date(),0.1,false,country,stats);
        parrotManager.addParrot(parrot);
        country = new Country("Canada");
        stats = new ParrotStats("Rob",2,"niebieski");
        parrot = new Parrot("Nelepsittacus",new Date(),0.4,true,country,stats);
        parrotManager.addParrot(parrot);
    }

}
