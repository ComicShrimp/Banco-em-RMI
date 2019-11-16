import java.sql.*;

public class Database {
  public Database(String databaseName) {

    try {
      Class.forName("org.sqlite.JDBC");
      Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
    } catch (Exception error) {
      System.out.println("Ocorreu um Erro: " + error.toString());
    }

    System.out.println("Conexão Feita com sucesso.");
  }
}