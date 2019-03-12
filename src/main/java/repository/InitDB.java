package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitDB {
    public static final String CREATE_USER_TABLE =
            "CREATE TABLE IF NOT EXISTS users(" +
            "id INT AUTO_INCREMENT," +
            "login VARCHAR(50) NOT NULL," +
            "'order' INT" +
            "CONSTRAINT users_pk PRIMARY KEY(id)" +
            ");";

    public static final String CREATE_BOOK_TABLE =
            "CREATE TABLE IF NOT EXISTS books(" +
            "id INT AUTO_INCREMENT," +
            "'name' VARCHAR(50) NOT NULL," +
            "author VARCHAR(50) NOT NULL," +
            "price DECIMAL NOT NULL" +
            "CONSTRAINT books_pk PRIMARY KEY(id)" +
            "); ";

    public static final String CREATE_ORDER_TABLE =
            "CREATE TABLE IF NOT EXISTS orders(" +
            "id INT AUTO_INCREMENT," +
            "bookID INT NOT NULL," +
            "userID INT NOT NULL" +
            "CONSTRAINT orders_pk PRIMARY KEY (id) " +
            "FOREIGN KEY() REFERENCES (?,?,?)," +
                    "CONSTRAINT orders_books_id_fk " +
                    "FOREIGN KEY (bookID) REFERENCES books (id)" +
                    "CONSTRAINT orders_users_id_fk " +
                    "FOREIGN KEY (userID) REFERENCES users (id)" +
                    "); " +
                    "CREATE UNIQUE INDEX orders_id_uindex " +
                    "ON orders (id) " +
                    "ALTER TABLE orders " +
                    "ADD CONSTRAINT orders_pk " +
                    "PRIMARY KEY (id)";


    public static void init(){
        try (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement stmt1 = connection.prepareStatement(CREATE_USER_TABLE);
            PreparedStatement stmt2 = connection.prepareStatement(CREATE_BOOK_TABLE);
            PreparedStatement stmt3 = connection.prepareStatement(CREATE_ORDER_TABLE);
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            stmt3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
