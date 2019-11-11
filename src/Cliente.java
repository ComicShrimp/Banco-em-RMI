import java.rmi.Naming;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
	
		try {
      BancoVinteQuatro obj = (BancoVinteQuatro) Naming.lookup("//192.168.1.107:1099/servidorbanco");
      System.out.println(obj.getSessao("abcdefgh"));
			
		}catch (Exception e ) {
			e.printStackTrace();
		}

	}

}