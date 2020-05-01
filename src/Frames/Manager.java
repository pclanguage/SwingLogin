package Frames;


import Security.GlobalInfo;
import Security.Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import static java.awt.PageAttributes.MediaType.D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

    public class Manager extends JFrame implements ActionListener {

        Container scontainer = getContentPane();
        JLabel signlavel = new JLabel(new ImageIcon("D:\\SwingGui\\Image\\sun.jpg"));
        JLabel appLabel = new JLabel("Welcome to Manager Frame ");

        JButton backButton = new JButton("Back");


        ImageIcon icon;

        public Manager() {
            this.setTitle(" Manager Frame");
            this.setBounds(500, 100, 570, 700);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);


            icon = new ImageIcon("image/sun.jpg");
            this.setIconImage(icon.getImage());

            Initialize();
            addActionEvent();


        }

        public void Initialize() {

            scontainer.setLayout(null);
            scontainer.setBackground(Color.yellow);

            signlavel.setBounds(0, 0, 0, 300);
            signlavel.setHorizontalAlignment(SwingConstants.CENTER);
            signlavel.setOpaque(true);
            scontainer.add(signlavel);

            appLabel.setBounds(25, 40, 380, 60);
            appLabel.setForeground(new Color(0, 0, 153));
            appLabel.setFont(new Font("Georgia", Font.ITALIC, 47));
            appLabel.setHorizontalAlignment(SwingConstants.CENTER);
            scontainer.add(appLabel);


            backButton.setBounds(145, 400, 120, 30);
            backButton.setHorizontalTextPosition(SwingConstants.CENTER);
            backButton.setVerticalTextPosition(SwingConstants.CENTER);
            backButton.setBackground(Color.gray);
            backButton.setFont(new Font("Georgia", Font.BOLD, 25));
            scontainer.add(backButton);


        }

        public void addActionEvent() {

            backButton.addActionListener(this);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                this.setVisible(false);
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
            }

        }

    }