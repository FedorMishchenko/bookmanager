package common;

public class SqlQueries {
/*
---------------------------------------------------------
*/
    public static final String CREATE_USER = "INSERT INTO users (login) VALUES" +
        "(?)";
    public static final String GET_USER = "SELECT id, login, order FROM users " +
            "WHERE login = ?";
    public static final String UPDATE_USER = "UPDATE users SET id = ?, login = ?, order = ? " +
            "WHERE login = ?";
    public static final String DELETE_USER = "DELETE FROM users WHERE login = ?";
    public static final String GET_ALL_USERS = "SELECT * FROM users";

/*
---------------------------------------------------------
*/
    public static final String CREATE_BOOK = "INSERT INTO books (name, author, price) " +
        "VALUES (?, ?, ?)";
    public static final String GET_BOOK = "SELECT id, name, author, price FROM books " +
            "WHERE id = ?";
    public static final String UPDATE_BOOK = "UPDATE books SET id = ?, name = ?, author = ?," +
            "price = ? WHERE id = ?";
    public static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    public static final String GET_ALL_BOOKS = "SELECT * FROM books";

/*
---------------------------------------------------------
*/
    public static final String CREATE_ORDER = "INSERT INTO orders (bookID, userID) VALUES " +
        "(?, ?)";
    public static final String GET_ORDER = "SELECT id, bookID FROM orders WHERE userID = ?";
    public static final String UPDATE_ORDER = "UPDATE orders SET bookID = ? WHERE userID = ?";
    public static final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";
    public static final String GET_ALL_ORDERS = "SELECT * FROM orders";

/*
---------------------------------------------------------
*/

}
