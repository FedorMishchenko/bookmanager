package repository;

public class DBFactory {
    private Connector connector;
    public DBFactory(){
        this.connector = new JdbcConnector();
    }
    public Connector getInstance(){
        return connector;
    }
}
