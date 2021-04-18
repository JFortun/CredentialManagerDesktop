package org.fortun.credmandesk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CredentialManager extends JFrame implements ActionListener {

    public CredentialManager() {

        View.credentialManager.setSize(1200, 800);
        View.credentialManager.setResizable(false);
        View.credentialManager.setLayout(null);
        View.credentialManager.setLocationRelativeTo(null);
        View.credentialManager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.credentialManager.setVisible(true);
        View.btnCredentialManagerManageUser.setBounds(550, 50, 120, 30);
        View.btnCredentialManagerSignOut.setBounds(50, 50, 95, 30);
        View.btnCredentialManagerManageUser.addActionListener(this);
        View.btnCredentialManagerSignOut.addActionListener(this);
        View.credentialManager.add(View.btnCredentialManagerManageUser);
        View.credentialManager.add(View.btnCredentialManagerSignOut);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(View.btnCredentialManagerManageUser)) {
            System.out.println("Manage User");
        } else if (actionEvent.getSource().equals(View.btnCredentialManagerSignOut)) {
            System.out.println("Sign Out");
            View.credentialManager.setVisible(false);
            View.login.setVisible(true);
        }
    }
}
