package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDao;
import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {

    public static void main( String[] args ) {

        FournisseurDao dao = new FournisseurDaoJdbc();

        List<Fournisseur> fournisseurs = dao.extraire();

        for (Fournisseur f : fournisseurs){
            System.out.println(f.toString());
        }

    }

}
