package persistance;

import meserreurs.MonException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connexion {


    private static Connexion instance = null;

    // on rend le constructeur privé
    // pour empêcher toute création d'instance
    private Connexion() {
    }

    // On utilise un singleton
    public static Connexion getInstance() {
        if (instance == null)
            instance = new Connexion();

        return instance;

    }

    public Connection getConnexion() throws MonException {
        Connection conn = null;
        try {
            Context ctxt = new InitialContext();
            // On recherche la data source
            DataSource ds = (DataSource) ctxt.lookup("java:/DSInscription");
            conn = ds.getConnection();

        } catch (SQLException e) {
            throw new MonException(e.getMessage());
        } catch (Exception e) {
            throw new MonException(e.getMessage());
        }
        return conn;
    }


}
