package Security;

/**
 * Created by USER on 5/2/2020.
 */

import Frames.Dashboard;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener {
    Container stcontainer = getContentPane();

    JLabel Label = new JLabel("Log in");

    JTextField usertextfield = new JTextField();
    JPasswordField passwordfield = new JPasswordField();

    JCheckBox showPassword = new JCheckBox();

    JButton loginButton = new JButton("Log in");
    JButton backButton = new JButton("Back");
    ImageIcon icon;
    public Login() {
        this.setTitle("Alo's Restaurent");
        this.setBounds(500, 100, 400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //this.setIconImage(ToolKit.getDefaultToolKit().getImage("D:\\sun.jpg"));
        icon = new ImageIcon("image/sun.jpg");
        this.setIconImage(icon.getImage());

        IniStaff();
        addActionEvent();


    }
    public void IniStaff() {

        stcontainer.setLayout(null);
        stcontainer.setBackground(Color.YELLOW);

        Label.setBounds(65, 82, 250, 56);
        Label.setForeground(new Color(0, 0, 153));
        Label.setFont(new Font("Georgia", Font.ITALIC, 50));
        Label.setHorizontalAlignment(SwingConstants.CENTER);
        stcontainer.add(Label);

        usertextfield.setBounds(42, 185, 312, 37);
        usertextfield.setToolTipText("Enter user name");
        usertextfield.setFont(new Font("Georgia", Font.PLAIN, 16));
        stcontainer.add(usertextfield);

        // passwordfield.setBounds(42,185,312,37);
        passwordfield.setBounds(40, 258, 314, 37);
        passwordfield.setToolTipText("Enter Password");
        passwordfield.setFont(new Font("Georgia", Font.PLAIN, 16));
        stcontainer.add(passwordfield);


        showPassword.setBounds(360, 267, 20, 20);
        showPassword.setBackground(Color.yellow);
        showPassword.setToolTipText("Show Password");
        stcontainer.add(showPassword);


        loginButton.setBounds(145, 354, 120, 30);
        loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
        loginButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginButton.setBackground(Color.GREEN);
        loginButton.setFont(new Font("Georgia", Font.BOLD, 25));
        stcontainer.add(loginButton);

        backButton.setBounds(145, 400, 120, 30);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setBackground(Color.gray);
        backButton.setFont(new Font("Georgia", Font.BOLD, 25));
        stcontainer.add(backButton);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== backButton ){
            this.setVisible(false);
            Dashboard dashboard= new Dashboard();
            dashboard.setVisible(true);
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordfield.setEchoChar((char) 0);

            } else {
                passwordfield.setEchoChar((char) 8226);
            }
        }
        if (e.getSource() == loginButton) {

            String userText;
            String passText;

            userText = usertextfield.getText().toString();
            passText = passwordfield.getText().toString();

            try {
                String path = "E:\\urmee\\SwingLogin\\users.txt";
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);

                String fuser, fpass, line, userRole;
                boolean isLoginSuccess = false;

                while ((line = br.readLine()) != null) {
                    String[] arrOfStr = line.split(" ");

//                      for (String a : arrOfStr)
//                          System.out.println(a);

                    fuser =arrOfStr[0];
                    fpass =arrOfStr[1];
                    userRole = arrOfStr[2];

                  //  System.out.print(line);
                    if (fuser.equals(userText) && fpass.equals(passText)) {
                        isLoginSuccess = true;
                        GlobalInfo.isLoggedIn = true;
                        GlobalInfo.userRole = userRole;
                        GlobalInfo.username = userText;
//                        System.out.print(GlobalInfo.userRole);

                        //open logged frame

                        this.setVisible(false);
                        Dashboard dashboard= new Dashboard();
                        dashboard.setVisible(true);

                        break;
                    }
                }
                if (!isLoginSuccess) {
                    JOptionPane.showMessageDialog(null, "USERNAME or PASSWORD WRONG", "WARNING!!", JOptionPane.WARNING_MESSAGE);
                }
                fr.close();

            } catch (Exception ep) {
                ep.printStackTrace();
            }


        }


    }
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
