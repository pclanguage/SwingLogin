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


public class Dashboard extends JFrame implements ActionListener {

    Container scontainer = getContentPane();
    JLabel signlavel = new JLabel(new ImageIcon("D:\\SwingGui\\Image\\sun.jpg"));
    JLabel appLabel = new JLabel("Welcome to Alo's ");
    JLabel appLabel1 = new JLabel("XY Company");
    String loginText = "";

    JButton LoginButton = new JButton("Login");
    JButton staffButton = new JButton("STAFF");
    JButton ManagerButton = new JButton("MANAGER");
    JButton logoutButton = new JButton("Logout");

    ImageIcon icon;

    public Dashboard() {
        this.setTitle("Alo's Restaurent");
        this.setBounds(400, 100, 770, 500);
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

        signlavel.setBounds(0, 0, 0, 400);
        signlavel.setHorizontalAlignment(SwingConstants.CENTER);
        signlavel.setOpaque(true);
        scontainer.add(signlavel);

        appLabel.setBounds(25, 40, 380, 60);
        appLabel.setForeground(new Color(0, 0, 153));
        appLabel.setFont(new Font("Georgia", Font.ITALIC, 47));
        appLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scontainer.add(appLabel);

        appLabel1.setBounds(25, 95, 500, 60);
        appLabel1.setForeground(new Color(0, 0, 153));
        appLabel1.setFont(new Font("Georgia", Font.ITALIC, 50));
        appLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        scontainer.add(appLabel1);


        if (GlobalInfo.isLoggedIn) {
            loginText = GlobalInfo.username + "  is logged in as " + GlobalInfo.userRole.toString();
        } else {
            loginText = "Please Login to access... ";
        }
        JLabel appLabel2 = new JLabel(loginText);

        appLabel2.setBounds(25, 155, 700, 60);
        appLabel2.setForeground(new Color(0, 0, 153));
        appLabel2.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        appLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        scontainer.add(appLabel2);


        if (GlobalInfo.isLoggedIn) {
            System.out.print(GlobalInfo.userRole);
            if (GlobalInfo.userRole.equals("staff")) {
                staffButton.setBounds(200, 230, 120, 30);
                staffButton.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
                staffButton.setVerticalTextPosition(SwingConstants.CENTER);
                staffButton.setBackground(Color.green);
                staffButton.setFont(new Font("Georgia", Font.BOLD, 20));
                scontainer.add(staffButton);
            }
            if (GlobalInfo.userRole.equals("manager")) {
                ManagerButton.setBounds(185, 280, 150, 30);
                ManagerButton.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
                ManagerButton.setVerticalTextPosition(SwingConstants.CENTER);
                ManagerButton.setBackground(Color.green);
                ManagerButton.setFont(new Font("Georgia", Font.BOLD, 20));
                scontainer.add(ManagerButton);
            }

            logoutButton.setBounds(200, 320, 120, 30);
            logoutButton.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
            logoutButton.setVerticalTextPosition(SwingConstants.CENTER);
            logoutButton.setBackground(Color.green);
            logoutButton.setFont(new Font("Georgia", Font.BOLD, 20));
            scontainer.add(logoutButton);

        } else {

            LoginButton.setBounds(200, 230, 120, 30);
            LoginButton.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
            LoginButton.setVerticalTextPosition(SwingConstants.CENTER);
            LoginButton.setBackground(Color.green);
            LoginButton.setFont(new Font("Georgia", Font.BOLD, 20));
            scontainer.add(LoginButton);
        }

    }

    public void addActionEvent() {


        staffButton.addActionListener(this);
        ManagerButton.addActionListener(this);
        LoginButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginButton) {
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        } else if (e.getSource() == staffButton) {
            this.setVisible(false);
            Staff staff = new Staff();
            staff.setVisible(true);
        } else if (e.getSource() == ManagerButton) {
            this.setVisible(false);
            Manager manager = new Manager();
            manager.setVisible(true);
        } else if (e.getSource() == logoutButton) {
            GlobalInfo.isLoggedIn = false;
            GlobalInfo.userRole = "";
            GlobalInfo.username = "";
            this.setVisible(false);
            this.setVisible(true);
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        }

    }

}