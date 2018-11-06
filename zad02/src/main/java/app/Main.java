package app;

import app.domain.Parrot;
import app.service.ParrotService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        ParrotService parrotService = new ParrotService();

        parrotService.addParrot(new Parrot("Nymphicus hollandicus",new Date(),0.2,true));
        parrotService.addParrot(new Parrot("Cuculus canorus",new Date(),0.5,false));
        parrotService.deleteParrot("Nymphicus hollandicus");

    }
}
