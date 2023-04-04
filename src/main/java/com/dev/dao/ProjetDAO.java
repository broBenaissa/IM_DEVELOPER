package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Projet;

public class ProjetDAO {
	private String jdbcURL = "jdbc:mysql://localhost/imdevelopper?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "salma-4u";

	private static final String INSERT_PROJETS_SQL = "INSERT INTO projet" + "  (name, description, image) VALUES " + " (?, ?, ?);";

	private static final String SELECT_PROJETS_BY_ID = "select id,name,description,image from projet where id =?";
	private static final String SELECT_ALL_PROJETS = "select * from projet";
	private static final String DELETE_PROJETS_SQL = "delete from projet where id = ?;";
	private static final String UPDATE_PROJETS_SQL = "update projet set name = ?,description= ?, image =? where id = ?;";

	public ProjetDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertProjet(Projet projet) throws SQLException {
		System.out.println(INSERT_PROJETS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJETS_SQL)) {
			preparedStatement.setString(1, projet.getName());
			preparedStatement.setString(2, projet.getDescription());
			preparedStatement.setString(3, projet.getImage());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Projet selectProjet(int id) {
		Projet projet = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJETS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String image = rs.getString("image");
				projet = new Projet(id, name, description, image);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return projet;
	}

	public List<Projet> selectAllProjets() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Projet> projets = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJETS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String image = rs.getString("image");
				projets.add(new Projet(id, name, description, image));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return projets;
	}

	public boolean deleteProjet(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PROJETS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateProjet(Projet projet) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PROJETS_SQL);) {
			statement.setString(1, projet.getName());
			statement.setString(2, projet.getDescription());
			statement.setString(3, projet.getImage());
			statement.setInt(4, projet.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
