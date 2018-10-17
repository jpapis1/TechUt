package app;

import app.domain.Parrot;
import app.service.ParrotService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ParrotService parrotService = new ParrotService();

        parrotService.addParrot(new Parrot("Nymphicus hollandicus","Kajetan",11,"Australia"));
    }
}
