package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc implements FournisseurDao {

    private static final String SELECT_QUERY = "SELECT * FROM fournisseur";
    private static final String INSERT_QUERY = "INSERT INTO `compta`.`fournisseur` (`NOM`) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE `compta`.`fournisseur` SET `NOM`= ? WHERE `NOM`= ?  ;";
    private static final String DELETE_QUERY = "DELETE FROM `compta`.`fournisseur` WHERE  `NOM`= ? ;";

    @Override
    public List<Fournisseur> extraire() {

        Connection connection = null;
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            PreparedStatement pSt = connection.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = pSt.executeQuery();
            while (resultSet.next()){
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(resultSet.getInt("id"));
                fournisseur.setNom(resultSet.getString("nom"));
                fournisseurs.add(fournisseur);
            }
            pSt.close();

            return fournisseurs;

        } catch ( SQLException e ) {
            fournisseurs = null;
            e.printStackTrace();
            return null;
        } finally {
            try {
                if ( null != connection && connection.isValid( 2 )) {
                    connection.close();
                }
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert(Fournisseur fournisseur) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            PreparedStatement st = connection.prepareStatement(INSERT_QUERY);
            st.setString(1, fournisseur.getNom());
            int nb = st.executeUpdate();
            st.close();
        } catch ( SQLException e ) {
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

    }

    @Override
    public int update(String ancienNom, String nouveauNom) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            PreparedStatement st = connection.prepareStatement(UPDATE_QUERY);
            st.setString(1, nouveauNom);
            st.setString(2, ancienNom);
            int nb = st.executeUpdate();
            st.close();
            return 1;
        } catch ( SQLException e ) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if ( null != connection && connection.isValid( 2 )) {
                    connection.close();
                }
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            PreparedStatement st = connection.prepareStatement(DELETE_QUERY);
            st.setString(1, fournisseur.getNom());
            int nb = st.executeUpdate();
            st.close();
        } catch ( SQLException e ) {
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

        return false;
    }

}
