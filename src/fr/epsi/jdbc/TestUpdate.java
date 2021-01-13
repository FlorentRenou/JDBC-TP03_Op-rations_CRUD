package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDao;
import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;


public class TestUpdate {

    public static void main( String[] args ) {

        FournisseurDao dao = new FournisseurDaoJdbc();

        dao.update("Fourni2","Fourni21");

    }

}
