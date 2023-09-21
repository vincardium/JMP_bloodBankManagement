package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonorDAO {

    private Connection connection;

    public DonorDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertDonor(Donor donor) {
        String sql = "INSERT INTO donors (name, email, blood_type, contact) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, donor.setName(null));
            preparedStatement.setString(2, donor.setEmail(null));
            preparedStatement.setString(3, donor.setBloodType(null));
            preparedStatement.setString(4, donor.setContact(sql));

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}