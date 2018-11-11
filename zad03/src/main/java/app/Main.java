package app;

import app.domain.Parrot;
import app.service.ParrotService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ParrotService parrotService = new ParrotService();
        parrotService.addParrot(new Parrot("Nymphicus hollandicus",new GregorianCalendar(2015, 0, 1).getTime(),0.2,true));
        parrotService.addParrot(new Parrot("Cuculus canorus",new GregorianCalendar(2011, 3, 14).getTime(),0.5,false));
        parrotService.addParrot(new Parrot("Columbidae",new GregorianCalendar(2013, 4, 10).getTime(),1.2,false));
        parrotService.deleteParrot("Nymphicus hollandicus");
        List<Parrot> parrots = parrotService.getAllParrots();
        List<Parrot> exoticParrots = parrotService.getExoticParrots();
        Parrot oldest = parrotService.getTheOldestParrot();
        parrots.forEach(System.out::println);
        exoticParrots.forEach(System.out::println);
        System.out.println(oldest);

        System.out.println();
        parrotService.printAllParrots();
    }
}
