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
    }
}
