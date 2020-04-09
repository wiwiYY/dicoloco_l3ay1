package com.dicoloco.constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe de configuration de la DataBase MySQL
 */
public class Identifiant {
	
	//l'id de MySQL
	private String id = "root";
	
	//Mdp de MySQL
	private String password = "root";
	
	//Nom de la DataBase de MySQL
	private String dbname = "word";
	
	public String getDb() {
		return dbname;
	}

	public void setDb(String db) {
		this.dbname = db;
	}

	private static Identifiant INSTANCE;
	
	public Identifiant() {
		
	}
	
	public static Identifiant getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Identifiant();
		}
		
		return INSTANCE;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Statement getStatement() {
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ dbname +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", this.id, this.password);
			Statement myStmt = myConn.createStatement();
			return myStmt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
