package service;

import domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class OwnerTest {
    @Autowired
    OwnerManager ownerManager;
    @Autowired
    ParrotManager parrotManager;
    @Test
    public void getOwnersParrot() {
        generateData();
        List<Parrot> list = ownerManager.getOwnersParrots("Jan", "Kowalski");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        Assert.assertEquals(list.size(),2);
        //System.out.println("GET TEST: " + parrotManager.getParrotByName("Nimfa") + list.size());
    }
    public void generateData() {
        Country country = new Country("Australia");
        ParrotStats stats = new ParrotStats("Bury",3,"zielony");
        HygieneProduct fProduct = new HygieneProduct("FeatherProduct");
        HygieneProduct sProduct = new HygieneProduct("SkinProduct");
        HygieneProduct vProduct = new HygieneProduct("VitalityProduct");
        Set<HygieneProduct> productSet = new HashSet<>();
        productSet.add(fProduct);
        productSet.add(sProduct);
        Set<HygieneProduct> productSet2 = new HashSet<>();
        productSet2.add(vProduct);
        productSet2.add(fProduct);


        List<Parrot> listOfParrots = new ArrayList<>();
        Parrot parrot = new Parrot("Nimfa",new Date(),0.3,true,country,stats);
        parrot.setProducts(productSet);
        Parrot parrot2 = new Parrot("Raba",new Date(),1.3,false,country,stats);
        parrotManager.addParrot(parrot2);
        parrot.setProducts(productSet);
        listOfParrots.add(parrot);
        listOfParrots.add(parrot2);
        Owner owner = new Owner("Jan","Kowalski");
        owner.setParrots(listOfParrots);
        ownerManager.addOwner(owner);
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
