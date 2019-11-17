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
      this.statement = connection.createStatement();
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS cliente "
          + "(ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT, NAME TEXT NOT NULL, SALDO REAL NOT NULL);");
      statement.close();
      connection.close();

    } catch (Exception error) {
      System.out.println("Ocorreu um Erro: " + error.toString());
    }

    System.out.println("Conexão Feita com sucesso.");
  }

  public void insertUser(User usuario) {
    try {

      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
      connection.setAutoCommit(false);
      this.statement = connection.createStatement();
      statement.executeUpdate("INSERT INTO " + this.databaseName + " (NAME, SALDO) values (" + usuario.getNome() + ","
          + usuario.getSaldo() + ");");

      statement.close();
      connection.commit();
      connection.close();

    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }
  }

  public User getUser(String id) {
    try {

      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.databaseName + ".db");
      connection.setAutoCommit(false);
      this.statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery("SELECT * FROM " + this.databaseName + "WHERE ID = " + id + ";");

      resultset.next();

      User user = new User(resultset.getString("NAME"), resultset.getDouble("SALDO"));

      resultset.close();
      statement.close();
      connection.close();

      return user;

    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }

    return new User("Teste", 9.0);
  }

  public boolean fazTrasacao(String id) {

    return true;
  }
}