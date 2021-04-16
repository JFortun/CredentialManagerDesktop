package org.fortun.credmandesk;

import javax.swing.*;

public class CredentialManager extends JFrame {

    public CredentialManager() {

        View.credentialManager.setSize(1200, 800);
        View.credentialManager.setResizable(false);
        View.credentialManager.setLayout(null);
        View.credentialManager.setLocationRelativeTo(null);
        View.credentialManager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.credentialManager.setVisible(true);
        View.btnCredentialManagerManageUser.setBounds(550, 50, 120, 30);
        View.btnCredentialManagerSignOut.setBounds(50, 50, 95, 30);
        View.credentialManager.add(View.btnCredentialManagerManageUser);
        View.credentialManager.add(View.btnCredentialManagerSignOut);
    }
}
