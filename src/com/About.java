package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    About frame = new About();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public About() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("About Our Blood Donation System");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(10, 11, 764, 29);
        contentPane.add(titleLabel);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setText(
                "Welcome to our Blood Donation System, a platform dedicated to saving lives through voluntary blood donations and raising awareness about the importance of donating blood.\n\n"
                        + "Key Features:\n\n"
                        + "- **Donor Registration**: We offer a seamless and user-friendly registration process for blood donors, making it convenient for individuals to join our mission.\n"
                        + "- **Blood Stock Management**: Our system efficiently manages and tracks blood inventory, ensuring that hospitals and clinics have access to an adequate blood supply.\n"
                        + "- **Donor Outreach**: We actively engage with donors and potential donors to inform them about upcoming donation drives, events, and the urgent need for blood.\n"
                        + "- **Educational Resources**: Our platform provides educational materials and resources to raise awareness about the significance of blood donation and its impact on saving lives.\n"
                        + "- **Donation Tracking**: Donors can easily track their donation history and receive updates on how their contributions have made a difference.\n\n"
                        + "We believe that every drop of blood donated has the potential to save a life. By using our Blood Donation System, you are becoming a part of this noble cause, helping us ensure a steady blood supply for those in need.\n\n"
                        + "Thank you for being a lifesaver and making a positive impact on your community through blood donation."
        );

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 51, 764, 448);
        contentPane.add(scrollPane);
    }
}