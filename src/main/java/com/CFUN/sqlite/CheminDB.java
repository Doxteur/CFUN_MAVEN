package com.CFUN.sqlite;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public interface CheminDB {
	SQLiteDataSource ds = new SQLiteDataSource();

	public static void setUrl() {
		// Chemin ou va se créer le fichier
		ds.setUrl("CFUNGIT/database.db");
	}

	//Méthode pour la connection
	public static Connection connect() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}
}
