package misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    private static Connect instance = null;
    private Connection conn = null;

    protected Connect() {}

    public static synchronized Connect getInstance() {
        if(Connect.instance == null) {
            Connect.instance = new Connect();
        }

        return Connect.instance;
    }

    public synchronized Connection getConnection() {
        if(this.conn == null) {
            try {
                InputStream input = new FileInputStream("./src/main/java/misc/db.properties");
                Properties properties = new Properties();
                properties.load(input);

                String connectionUrl = properties.getProperty("CONNECTION_URL");
                String user = properties.getProperty("USER");
                String password = properties.getProperty("PASSWORD");

                this.conn = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("Successfully connected.");
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return this.conn;
    }
}
