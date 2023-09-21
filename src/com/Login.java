package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class Login implements ActionListener{

	public JFrame frame;
	public JPasswordField passwordField;
	private JTextField txtBloodbankManagementSystem;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize()  {
		  
		
		frame = new JFrame();
		frame.setTitle("Login Page");
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(540, 122, 203, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea username = new JTextArea();
		username.setBounds(22, 39, 118, 22);
		panel.add(username);
		
		
		JLabel usernameLabel = new JLabel("UserName");
		usernameLabel.setBounds(22, 10, 80, 19);
		panel.add(usernameLabel);
		usernameLabel.setForeground(new Color(0, 0, 0));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(22, 82, 80, 26);
		panel.add(passLabel);
		passLabel.setForeground(new Color(0, 0, 0));
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(22, 118, 118, 26);
		panel.add(passwordField);
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (e.getSource() == loginbtn) {
			    	//Home launch = new Home();
		            //launch.setVisible(true);
		            //frame.setVisible(false);
			        String userText = username.getText(); // Retrieve the entered username
			        @SuppressWarnings("deprecation")
					String pwdText = passwordField.getText(); // Retrieve the entered password

			        if (userText.equalsIgnoreCase("admin") && pwdText.equals("12345")) {
			            //JOptionPane.showMessageDialog(null, "Login Successful");
			            Home launch = new Home();
			            launch.setVisible(true);
			            frame.setVisible(false);
			        } else if(userText.equals("") || pwdText.equals("")){
			        	JOptionPane.showMessageDialog(null, "Please Enter username and password");
			        	username.setText("");
			            passwordField.setText("");
			        }
			        else {
			            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			            username.setText("");
			            passwordField.setText("");
			        }
			    }
			}

		});
		loginbtn.setActionCommand("Home");
		loginbtn.setBounds(22, 174, 103, 35);
		panel.add(loginbtn);
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginbtn.setForeground(new Color(0, 0, 0));
		loginbtn.setBackground(new Color(255, 255, 0));
		
		txtBloodbankManagementSystem = new JTextField();
		txtBloodbankManagementSystem.setBorder(new CompoundBorder());
		txtBloodbankManagementSystem.setBackground(new Color(255, 0, 0));
		txtBloodbankManagementSystem.setBounds(264, 30, 272, 49);
		frame.getContentPane().add(txtBloodbankManagementSystem);
		txtBloodbankManagementSystem.setForeground(new Color(255, 255, 0));
		txtBloodbankManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBloodbankManagementSystem.setText("Blood Bank Management System");
		txtBloodbankManagementSystem.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
}
