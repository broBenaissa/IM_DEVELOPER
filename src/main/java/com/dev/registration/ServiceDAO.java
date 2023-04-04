package com.dev.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Service;


public class ServiceDAO {
	private String jdbcURL = "jdbc:mysql://localhost/data?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "salma-4u";

	private static final String INSERT_SERVICES_SQL = "INSERT INTO service" + "  (name, description, price) VALUES " + " (?, ?, ?);";

	private static final String SELECT_SERVICES_BY_ID = "select id,name,description,price from service where id =?";
	private static final String SELECT_ALL_SERVICES = "select * from service";
	private static final String DELETE_SERVICES_SQL = "delete from service where id = ?;";
	private static final String UPDATE_SERVICES_SQL = "update service set name = ?,description= ?, price =? where id = ?;";

	public ServiceDAO() {
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

	public void insertService(Service service) throws SQLException {
		System.out.println(INSERT_SERVICES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICES_SQL)) {
			preparedStatement.setString(1, service.getName());
			preparedStatement.setString(2, service.getDescription());
			preparedStatement.setString(3, service.getPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Service selectService(int id) {
		Service service = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICES_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				String price = rs.getString("price");
				service = new Service(id, name, description, price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return service;
	}

	public List<Service> selectAllServices() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Service> services = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String price = rs.getString("price");
				services.add(new Service(id, name, description, price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return services;
	}

	public boolean deleteService(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SERVICES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateService(Service service) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICES_SQL);) {
			statement.setString(1, service.getName());
			statement.setString(2, service.getDescription());
			statement.setString(3, service.getPrice());
			statement.setInt(4, service.getId());

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
