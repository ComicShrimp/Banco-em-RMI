import java.sql.*;

public class Database {
  Connection connection;
  Statement statement;
  String databaseName;

  public Database(String databaseName) {
    this.databaseName = databaseName;

    try {
      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
      statement = connection.createStatement();
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS cliente " + "(ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL, SALDO REAL NOT NULL);");
      statement.close();
      connection.close();

    } catch (Exception error) {
      System.out.println("Ocorreu um Erro: " + error.toString());
    }

    System.out.println("Conexão Feita com sucesso.");
  }

  public void insertUser (User usuario) {

  }

  public User getUser (String id) {
    return new User("Teste", 9.0);
  }

  public boolean fazTrasacao (String id) {

    return true;
  }
}