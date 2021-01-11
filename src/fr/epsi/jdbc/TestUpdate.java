package fr.epsi.jdbc;

import java.sql.*;


public class TestUpdate {

    public static void main( String[] args ) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            Statement st = connection.createStatement();
            int nb = st.executeUpdate( "UPDATE `compta`.`fournisseur` SET `NOM`='La Maison des Peintures' WHERE  `NOM`='La Maison de la Peinture';" );
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
