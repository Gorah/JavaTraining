package mod12.mysql;

import java.sql.*;

public class MyDatabase {
	private Connection conn;
	private Statement st;

	public void initConnection() throws SQLException {
		final String HOST = "localhost";
		final int PORT = 3306;
		final String DB_NAME = "jpr";
		final String USER_NAME = "root";
		final String PASSWORD = "admin";
		String dburl = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Niezarejestrowany sterownik");
			System.exit(0);
		}
		conn = DriverManager.getConnection(dburl, USER_NAME, PASSWORD);
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.println("Po³¹czenie nawi¹zane poprzez: "
				+ dbmd.getDriverName());
		st = conn.createStatement();
	}

	public void createTable() throws SQLException {
		final String SQL_CREATE = "CREATE TABLE klient (" + "id INT NOT NULL,"
				+ "imie VARCHAR(255)," + "nazwisko VARCHAR(255),"
				+ "region VARCHAR(255)," + "wiek INT," + "mezczyzna INT,"
				+ "PRIMARY KEY (id))";
		st.executeUpdate(SQL_CREATE);
	}

	public void insertRecords() throws SQLException {
		final String SQL_INSERT = "INSERT INTO klient VALUES ";
		st.executeUpdate(SQL_INSERT + "(1, 'Jan', 'Kowalski', 'pn', 30, 1)");
		st.executeUpdate(SQL_INSERT + "(2, 'Anna', 'Nowak', 'pd', 18, 2)");
		st.executeUpdate(SQL_INSERT + "(3, 'Stefan', 'Talarek', 'pn', 34, 1)");
	}

	public void queryAll() throws SQLException {
		final String SQL_SELECT = "SELECT * FROM klient";
		ResultSet rs = st.executeQuery(SQL_SELECT);

		System.out.println("\nDane w tabeli 'klient':");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int i = 1; i <= columns; i++)
			System.out.printf("%12s", rsmd.getColumnName(i));
		System.out.println();
		for (int i = 0; i < 12 * columns; i++)
			System.out.print("-");
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= columns; i++)
				System.out.printf("%12s", rs.getString(i));
			System.out.println();
		}
		rs.close();
	}

	public void dropTable() throws SQLException {
		final String SQL_DROP = "DROP TABLE klient";
		st.executeUpdate(SQL_DROP);
	}

	public void closeConnection() {
		try {
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyDatabase db = new MyDatabase();
		try {
			db.initConnection();
			db.createTable();
			db.insertRecords();
			db.queryAll();
			db.dropTable();
		} catch (SQLException e) {
			System.out.print("B³¹d bazy danych: " + e.getMessage());
		} finally {
			db.closeConnection();
		}
	}
}