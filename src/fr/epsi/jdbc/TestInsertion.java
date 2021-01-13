package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.*;

import fr.epsi.jdbc.entites.Fournisseur;
import fr.epsi.jdbc.resources.MyResource;

import java.sql.*;

public class TestInsertion {

    public static void main( String[] args ) {

        FournisseurDao dao = new FournisseurDaoJdbc();

        dao.insert(new Fournisseur("Fourni2"));

    }
}

