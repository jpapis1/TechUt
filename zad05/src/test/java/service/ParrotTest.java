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
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class ParrotTest {
    @Autowired
    ParrotManager parrotManager;
    @Test
    public void showAllParrotsTest() {
        List<Parrot> allParrots = parrotManager.getAllParrots();
        System.out.println();

        if(!allParrots.isEmpty()) {
            for(Parrot p : allParrots) {
                System.out.println(p.getName());
            }
        } else {
            System.out.println("Tablica papug pusta!");
        }
    }

    @Test
    public void addParrotTest() {
        Country country = new Country("Australia");
        ParrotStats stats = new ParrotStats("Bury",3,"zielony");
        Parrot parrot = new Parrot("Nimfa",new Date(),0.3,true,country,stats);
        parrotManager.addParrot(parrot);

    }

}
