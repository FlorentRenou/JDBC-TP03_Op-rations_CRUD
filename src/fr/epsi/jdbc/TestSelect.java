package fr.epsi.jdbc;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {

    public static void main( String[] args ) {
        Connection connection = null;
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            PreparedStatement pSt = connection.prepareStatement("SELECT * FROM fournisseur");
            ResultSet resultSet = pSt.executeQuery();
            while (resultSet.next()){
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(resultSet.getInt("id"));
                fournisseur.setNom(resultSet.getString("nom"));
                fournisseurs.add(fournisseur);
            }
            pSt.close();

        } catch ( SQLException e ) {
            fournisseurs = null;
            e.printStackTrace();
        } finally {
            try {
                if ( null != connection && connection.isValid( 2 )) {
                    connection.close();
                }
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        for (Fournisseur f : fournisseurs){
            System.out.println(f.toString());
        }
    }

}
