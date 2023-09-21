package com;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Info {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("The current blood bank management system faces several challenges and inefficiencies that hinder its ability to effectively serve the needs of both blood donors and recipients."
                + " These issues are impacting the overall efficiency, transparency, and responsiveness of the system, potentially putting lives at risk. Some key problems include:"
                + "\n\n"
                + "- Security and Privacy Concerns: Manual record keeping raises concerns about data security and privacy breaches, as sensitive donor and recipient information is vulnerable to unauthorized access."
                + "\n\n"
                + "- Emergency Response Delays: During emergencies, the lack of a streamlined system for quick coordination between blood banks and hospitals results in delays in providing timely blood units to patients in critical need."
                + "\n\n"
                + "- Lack of Education: Many individuals lack proper education about blood donation, including its benefits, the donation process, and the impact it has on saving lives. This lack of knowledge contributes to misconceptions and hesitation among potential donors.");
        label.setForeground(new Color(0x00FF00));  // Set text color to green
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(-25);
        label.setBackground(Color.black);
        label.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);  // Set frame size
        frame.setVisible(true);
        frame.add(label);
    }
}