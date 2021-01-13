package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDao;
import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;

public class TestDelete {

    public static void main( String[] args ) {

        FournisseurDao dao = new FournisseurDaoJdbc();

        dao.delete(new Fournisseur("Fourni666"));

    }

}
