package fr.epsi.jdbc;

import fr.epsi.jdbc.resources.MyResource;

import java.sql.*;

public class TestInsertion {

    public static void main( String[] args ) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "root");

            Statement st = connection.createStatement();
            int nb = st.executeUpdate( "INSERT INTO fournisseur (NOM) VALUES ('La maison de la Peinture')" );
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

