package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Projet;

public class PortfolioDAO {
    private Connection connection;

    public PortfolioDAO() throws SQLException {
    	connection = Database.getConnection();
    }

    public void add(Projet item) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO portfolio (id, name, description, url) VALUES (?, ?, ?, ?)");
            statement.setInt(1, item.getId());
            statement.setString(2, item.getTitre());
            statement.setString(3, item.getDescription());
            statement.setString(4, item.getUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Projet item) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE portfolio SET name = ?, description = ?, url = ? WHERE id = ?");
            statement.setString(1, item.getTitre());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getUrl());
            statement.setInt(4, item.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM portfolio WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Projet get(int id) {
        Projet item = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM portfolio WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                item = new Projet();
                item.setId(result.getInt("id"));
                item.setTitre(result.getString("name"));
                item.setDescription(result.getString("description"));
                item.setUrl(result.getString("url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public List<Projet> getAll() {
        List<Projet> items = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM portfolio");
            while (result.next()) {
            	Projet item = new Projet();
                item.setId(result.getInt("id"));
                item.setTitre(result.getString("name"));
                item.setDescription(result.getString("description"));
                item.setUrl(result.getString("url"));
                items.add(new Projet());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
