package service;

import domain.Country;
import domain.HygieneProduct;
import domain.Parrot;
import domain.ParrotStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ParrotTest {
    @Autowired
    ParrotManager parrotManager;

    @Test
    public void generateDataTest() {
        generateData();

    }
    @Test
    public void addParrotTest() {
        Country country = new Country("USA");
        ParrotStats stats = new ParrotStats("Leia",1,"czerwony");
        HygieneProduct sProduct = new HygieneProduct("SkinProduct");
        HygieneProduct vProduct = new HygieneProduct("VitalityProduct");
        HashSet<HygieneProduct> productSet = new HashSet<>();
        productSet.add(vProduct);
        productSet.add(sProduct);
        Parrot parrot = new Parrot("Riga",new Date(),1.2,false,country,stats);
        parrot.setProducts(productSet);
        parrotManager.addParrot(parrot);

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
        assertEquals(allParrots.size(),3);
    }
    @Test
    public void showAllExoticParrotsTest() {
        generateData();
        List<Parrot> exoticParrots = parrotManager.getAllExoticParrots();
        System.out.println();
        System.out.println("SHOW ALL EXOTIC PARROTS TEST");

        if(!exoticParrots.isEmpty()) {
            for(Parrot p : exoticParrots) {
                System.out.println(p.getName());
            }
        } else {
            System.out.println("Tablica papug egzotycznych pusta!");
        }
        assertEquals(exoticParrots.size(),2);
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
        HygieneProduct fProduct = new HygieneProduct("FeatherProduct");
        HygieneProduct sProduct = new HygieneProduct("SkinProduct");
        HygieneProduct vProduct = new HygieneProduct("VitalityProduct");
        HashSet<HygieneProduct> productSet = new HashSet<>();
        productSet.add(fProduct);
        productSet.add(sProduct);
        HashSet<HygieneProduct> productSet2 = new HashSet<>();
        productSet2.add(vProduct);
        productSet2.add(fProduct);



        Parrot parrot = new Parrot("Nimfa",new Date(),0.3,true,country,stats);
        parrot.setProducts(productSet);
        parrotManager.addParrot(parrot);
        country = new Country("USA");
        stats = new ParrotStats("Lexy",0,"brązowy");
        parrot = new Parrot("Strigopidae",new Date(),0.1,false,country,stats);
        parrot.setProducts(productSet2);
        parrotManager.addParrot(parrot);
        country = new Country("Canada");
        stats = new ParrotStats("Rob",2,"niebieski");
        parrot = new Parrot("Nelepsittacus",new Date(),0.4,true,country,stats);
        parrot.setProducts(productSet);
        parrotManager.addParrot(parrot);
    }

}
