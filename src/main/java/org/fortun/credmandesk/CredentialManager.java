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
            View.txtManageUserNameUser.setText(Main.user.getNameUser());
            View.txtManageUserPasswordUser.setText(Main.user.getPasswordUser());
            View.txtManageUserPasswordUserAgain.setText(Main.user.getPasswordUser());
            View.manageUser.setVisible(true);
        } else if (actionEvent.getSource().equals(View.btnCredentialManagerSignOut)) {
            View.credentialManager.setVisible(false);
            View.login.setVisible(true);
        }
    }
}
