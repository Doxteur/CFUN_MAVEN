package com.CFUN.sqlite;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public interface CheminDB {
	SQLiteDataSource ds = new SQLiteDataSource();
	// public static final String connection = "";
	// public static final String dataSource = "";
	// public static final String statement = "";

	public static void setUrl() {
		// Chemin
		ds.setUrl("CFUNGIT/database.db");
	}

	public static Connection connect() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}

	// Statement stmt = conn.createStatement();
}
