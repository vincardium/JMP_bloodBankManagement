package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Donate extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldContact;
    private JComboBox<String> bloodTypeDropdown;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Donate frame = new Donate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Donate() {
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
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblDonateBlood = new JLabel("Donate Blood");
        lblDonateBlood.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDonateBlood.setBounds(10, 11, 497, 39);
        panel.add(lblDonateBlood);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(10, 70, 57, 20);
        panel.add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(77, 70, 200, 20);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(10, 100, 57, 20);
        panel.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(77, 100, 200, 20);
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblBloodType = new JLabel("Blood Type:");
        lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBloodType.setBounds(10, 130, 97, 20);
        panel.add(lblBloodType);

        // Create a dropdown for blood types
        String[] bloodTypes = {"Select Type", "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"};
        bloodTypeDropdown = new JComboBox<>(bloodTypes);
        bloodTypeDropdown.setBounds(117, 130, 160, 20);
        panel.add(bloodTypeDropdown);

        JLabel lblContact = new JLabel("Contact:");
        lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblContact.setBounds(10, 160, 69, 20);
        panel.add(lblContact);

        textFieldContact = new JTextField();
        textFieldContact.setBounds(89, 160, 188, 20);
        panel.add(textFieldContact);
        textFieldContact.setColumns(10);

        JButton btnDonate = new JButton("Donate");
        btnDonate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get input values from the form
                String name = textFieldName.getText();
                String email = textFieldEmail.getText();
                String bloodType = (String) bloodTypeDropdown.getSelectedItem();
                String contact = textFieldContact.getText();

                // Create a donor object
                Donor donor = new Donor();
                donor.setName(name);
                donor.setEmail(email);
                donor.setBloodType(bloodType);
                donor.setContact(contact);

                // Establish a database connection
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/donors", "root", "root");
                    DonorDAO donorDAO = new DonorDAO(connection);

                    // Insert the donor into the database
                    boolean success = donorDAO.insertDonor(donor);

                    if (success) {
                        // Display a success message
                        JOptionPane.showMessageDialog(contentPane, "Thank you for donating blood!", "Donation Success", JOptionPane.INFORMATION_MESSAGE);
                        // Clear the form fields
                        textFieldName.setText("");
                        textFieldEmail.setText("");
                        bloodTypeDropdown.setSelectedIndex(0);
                        textFieldContact.setText("");
                    } else {
                        // Display an error message
                        JOptionPane.showMessageDialog(contentPane, "Failed to record donation. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnDonate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDonate.setBounds(10, 190, 100, 30);
        panel.add(btnDonate);
        
        btnDonate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle the donation process here
                // You can get the input values from textFieldName, textFieldEmail, bloodTypeDropdown, and textFieldContact
                // and perform the necessary database operations.

                // For now, display a success message
                String successMessage = "Your name is successfully put in the donation queue.\n";
                successMessage += "Please come to XYZ Hospital on [Date] at [Time] to donate blood.";
                // You can replace [Date] and [Time] with the actual date and time.
                // You can use the Date and Time classes in Java for this purpose.
                
                // Show the success message to the user
                JOptionPane.showMessageDialog(contentPane, successMessage, "Donation Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}