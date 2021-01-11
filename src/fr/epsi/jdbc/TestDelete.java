package fr.epsi.jdbc;

import java.sql.*;

public class TestDelete {

    public static void main( String[] args ) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            Statement st = connection.createStatement();
            int nb = st.executeUpdate( "DELETE FROM `compta`.`fournisseur` WHERE  `NOM`='La Maison des Peintures';" );
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

}
