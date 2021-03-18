package no.dnb.reskill.onlineretailer.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DatabaseSetup {
    @Value("${database}")
    private String database;


    public boolean isMySQL() {
        return database.equals("MySQL");
    }

    public boolean isH2() {
        return database.equals("H2");
    }

}
