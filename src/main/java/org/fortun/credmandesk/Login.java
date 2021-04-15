package org.fortun.credmandesk;

import javax.swing.*;

public class Login extends JFrame {

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
        View.btnLoginAccess.setBounds(50,130,95,30);
        View.btnLoginSignIn.setBounds(235,130,95,30);
        View.login.add(View.lblLoginNameUser);
        View.login.add(View.lblLoginPasswordUser);
        View.login.add(View.txtLoginNameUser);
        View.login.add(View.txtLoginPasswordUser);
        View.login.add(View.btnLoginAccess);
        View.login.add(View.btnLoginSignIn);
    }
}
