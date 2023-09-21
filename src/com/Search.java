package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class Search extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField title;
    private JTextField txtEnterCity;
    private Choice cityChoice;
    private Choice bloodTypeChoice;
    private JTextField txtBloodType;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search frame = new Search();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Search() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 766, 543);
        panel.setBackground(new Color(255, 0, 0));
        panel.setForeground(new Color(255, 255, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 88, 533, 39);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblSearchBlood = new JLabel("Search Blood Stock");
        lblSearchBlood.setBounds(10, 0, 497, 39);
        panel_1.add(lblSearchBlood);
        lblSearchBlood.setFont(new Font("Tahoma", Font.BOLD, 15));

        cityChoice = new Choice();
        cityChoice.add("Select City");
        cityChoice.add("Kurla");
        cityChoice.add("Chembur");
        cityChoice.add("Sion");
        cityChoice.add("Ghatkoper");
        cityChoice.add("Vashi");
        cityChoice.setForeground(Color.BLACK);
        cityChoice.setBounds(112, 199, 104, 34);
        panel.add(cityChoice);

        txtEnterCity = new JTextField();
        txtEnterCity.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtEnterCity.setBorder(new CompoundBorder());
        txtEnterCity.setBackground(new Color(255, 0, 0));
        txtEnterCity.setText("Enter City:");
        txtEnterCity.setBounds(10, 199, 96, 19);
        panel.add(txtEnterCity);
        txtEnterCity.setColumns(10);

        JTextArea stockOutput = new JTextArea();
        stockOutput.setFont(new Font("Tahoma", Font.BOLD, 15));
        stockOutput.setText("\t         Available Donors: ");
        stockOutput.setBounds(252, 158, 476, 345);
        panel.add(stockOutput);

        JButton btnNewButton = new JButton("Enter");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedCity = cityChoice.getSelectedItem();
                    String selectedBloodType = bloodTypeChoice.getSelectedItem();

                    if ("Select City".equals(selectedCity) || "Select Type".equals(selectedBloodType)) {
                        JOptionPane.showMessageDialog(contentPane, "Please select both City and Blood Type.", "Error", JOptionPane.ERROR_MESSAGE);
                        // Reset both input fields to their default values
                        cityChoice.select(0);
                        bloodTypeChoice.select(0);
                        return;
                    }

                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/search", "root", "root");

                    String query = "SELECT * FROM blood WHERE city = ? AND blood_type = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, selectedCity);
                    preparedStatement.setString(2, selectedBloodType);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    StringBuilder table = new StringBuilder();
                    table.append("\n                 City            |       ID        |     Blood Type\n");
                    table.append("         ----------------------------------------------------------\n");

                    while (resultSet.next()) {
                        String city = resultSet.getString("city");
                        String id = resultSet.getString("id");
                        String bloodType = resultSet.getString("blood_type");

                        table.append("                 ").append(city).append("          |        ").append(id).append("         |         ").append(bloodType).append("\n");
                    }

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();

                    stockOutput.setText("\t         Available Donors: \n" + table.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(70, 282, 85, 21);
        panel.add(btnNewButton);

        title = new JTextField();
        title.setBounds(10, 10, 553, 62);
        panel.add(title);
        title.setFont(new Font("Tahoma", Font.BOLD, 15));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Blood Stock Availability");
        title.setColumns(10);

        bloodTypeChoice = new Choice();
        bloodTypeChoice.add("Select Type");
        bloodTypeChoice.add("A+");
        bloodTypeChoice.add("B+");
        bloodTypeChoice.add("AB+");
        bloodTypeChoice.add("O+");
        bloodTypeChoice.add("A-");
        bloodTypeChoice.add("B-");
        bloodTypeChoice.add("AB-");
        bloodTypeChoice.add("O-");
        bloodTypeChoice.setForeground(Color.BLACK);
        bloodTypeChoice.setBounds(112, 243, 104, 34);
        panel.add(bloodTypeChoice);
        
        txtBloodType = new JTextField();
        txtBloodType.setText("Blood Type:");
        txtBloodType.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtBloodType.setColumns(10);
        txtBloodType.setBorder(new CompoundBorder());
        txtBloodType.setBackground(Color.RED);
        txtBloodType.setBounds(10, 243, 96, 19);
        panel.add(txtBloodType);
    }
}
