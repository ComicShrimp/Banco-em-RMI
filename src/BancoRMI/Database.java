package BancoRMI;

import java.sql.*;

public class Database {
  Connection connection;
  Statement statement;
  String databaseName;

  public Database(String databaseName, String nomeBanco) {
    this.databaseName = databaseName;

    try {
      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
      this.statement = connection.createStatement();
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + nomeBanco
          + "(ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT, NAME TEXT NOT NULL, SALDO REAL NOT NULL, CARDNUMBER TEXT NOT NULL, PASSWORD TEXT NOT NULL, NOMEBANCO TEXT NOT NULL);");
      statement.close();
      connection.close();

    } catch (Exception error) {
      System.out.println("Ocorreu um Erro: " + error.toString());
    }

    System.out.println("Conexão Feita com sucesso.");
  }

  public boolean updateUser(User usuario, String id) {
    try {
      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
      connection.setAutoCommit(false);
      this.statement = connection.createStatement();

      statement.executeQuery(
          "UPDATE " + this.databaseName + " set SALDO = " + usuario.getSaldo() + " WHERE ID = " + id + ";");
      connection.commit();

      statement.close();
      connection.close();

      return true;

    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
      return false;
    }
  }

  public void insertUser(User usuario) {
    try {

      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
      connection.setAutoCommit(false);
      this.statement = connection.createStatement();
      statement.executeUpdate("INSERT INTO " + usuario.getNomeBanco()
          + "(NAME, SALDO, CARDNUMBER, PASSWORD, NOMEBANCO) values (" + usuario.getNome() + "," + usuario.getSaldo()
          + "," + usuario.getCardNumber() + "," + usuario.getPassword() + "," + usuario.getNomeBanco() + ");");

      statement.close();
      connection.commit();
      connection.close();

    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }
  }

  public User getUser(User u) {
    try {

      Class.forName("org.sqlite.JDBC");
      this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.databaseName + ".db");
      connection.setAutoCommit(false);
      this.statement = connection.createStatement();
      ResultSet resultset = statement
          .executeQuery("SELECT * FROM " + u.getNomeBanco() + "WHERE ID = " + u.getId() + ";");

      resultset.next();

      User user = new User(resultset.getString("NAME"), resultset.getDouble("SALDO"), resultset.getString("CARDNUMBER"),
          resultset.getString("PASSWORD"), resultset.getString("NOMEBANCO"));
      user.setId(resultset.getInt("ID"));
      resultset.close();
      statement.close();
      connection.close();

      return user;

    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }

    User newUser = new User();
    newUser.setNome("Teste");
    newUser.setSaldo(9.0);

    return newUser;
  }
  /*
   * public boolean fazTrasacao(String id, double transacao) { User novoUser =
   * this.getUser(id);
   * 
   * if (transacao < 0 && novoUser.getSaldo() >= Math.abs(transacao)) { return
   * this.updateUser(novoUser, id); } else if (transacao >= 0) { return
   * this.updateUser(novoUser, id); }
   * 
   * return false; }
   */
}