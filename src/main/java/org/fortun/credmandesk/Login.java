package org.fortun.credmandesk;

import javax.swing.*;

public class Login extends JFrame {

    public Login() {

        View.login.setSize(400, 600);
        View.login.setResizable(false);
        View.login.setLocationRelativeTo(null);
        View.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        View.login.setVisible(true);
    }
}
