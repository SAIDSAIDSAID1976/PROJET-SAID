package thisthis;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public abstract class EtudiantDao1 {
	// cr�e une connection (lien)vers nue base de donn�es
		Connection cnx;
		// pour envoyer est ex�cuter des req�ete sql
		Statement st;
		// r�cuperation des resultats
		ResultSet rst;
		Scanner Sc = new Scanner(System.in);
	protected  String nom ="bougtoub";
	///////////////////////////////////////////////////////////////////////////////
	
	public void afficher1(){
		System.out.println("afficher le nom  = "+nom);
	} ;

	 public  void affichage() {
			cnx=EtudiantDao();
			String aff= "select*from etudiant";
			try {
				st = (Statement) cnx.createStatement();
				rst = st.executeQuery("select*from etudiant");
				while(rst.next()) {
					System.out.print(rst.getString("nom")+"\t");
					System.out.print(rst.getString("prenom")+"\t");
					System.out.print(rst.getDouble("cne")+"\t");
					System.out.print(rst.getDouble("note")+"\t");
					System.out.print(rst.getDouble("moyenne")+"\t");
					System.out.println("\n");
				}
					} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public Connection EtudiantDao() {
			String chaine = "jdbc:mysql://localhost:3306/gestionetudiant";
			try {
				Class.forName("com.mysql.jdbc.Driver");
							System.out.println("chargemment avec succ�s");
			} catch (ClassNotFoundException e1) {
				System.out.println("probl�me driver");
				e1.printStackTrace();
			} /// catch1
			try {
				cnx = (Connection) DriverManager.getConnection(chaine, "root", "");
				System.out.println("cnx avec suc�s");
				return cnx;
			} catch (SQLException e1) {
				System.out.println("probl�me de cnx ");
				e1.printStackTrace();
				return null;
			} //// catch2
		}
}
