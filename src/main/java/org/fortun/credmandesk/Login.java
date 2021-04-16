package org.fortun.credmandesk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    public Login() {

        View.login.setSize(400, 230);
        View.login.setResizable(false);
        View.login.setLayout(null);
        View.login.setLocationRelativeTo(null);
        View.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        View.login.setVisible(true);
        View.lblLoginNameUser.setBounds(50, 30, 75, 15);
        View.lblLoginPasswordUser.setBounds(50, 80, 75, 15);
        View.txtLoginNameUser.setBounds(150, 25, 175, 25);
        View.txtLoginPasswordUser.setBounds(150, 75, 175, 25);
        View.btnLoginSignIn.setBounds(50, 130, 95, 30);
        View.btnLoginSignUp.setBounds(235, 130, 95, 30);
        View.btnLoginSignIn.addActionListener(this);
        View.btnLoginSignUp.addActionListener(this);
        View.login.add(View.lblLoginNameUser);
        View.login.add(View.lblLoginPasswordUser);
        View.login.add(View.txtLoginNameUser);
        View.login.add(View.txtLoginPasswordUser);
        View.login.add(View.btnLoginSignIn);
        View.login.add(View.btnLoginSignUp);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(View.btnLoginSignIn)) {
            new CredentialManager();
        } else if (actionEvent.getSource().equals(View.btnLoginSignUp)) {
            new SignUp();
        }
    }
}
