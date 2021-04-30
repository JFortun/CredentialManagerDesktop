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
        View.btnCredentialManagerCreate.setBounds(925, 300, 200, 50);
        View.btnCredentialManagerUpdate.setBounds(925, 400, 200, 50);
        View.btnCredentialManagerDelete.setBounds(925, 500, 200, 50);
        View.scrollPaneCredentials.setBounds(100, 200, 750, 500);
        View.scrollPaneCredentials.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        View.btnCredentialManagerManageUser.addActionListener(this);
        View.btnCredentialManagerSignOut.addActionListener(this);
        View.credentialManager.add(View.btnCredentialManagerManageUser);
        View.credentialManager.add(View.btnCredentialManagerSignOut);
        View.credentialManager.add(View.btnCredentialManagerCreate);
        View.credentialManager.add(View.btnCredentialManagerUpdate);
        View.credentialManager.add(View.btnCredentialManagerDelete);
        View.credentialManager.add(View.scrollPaneCredentials);

        String[] credentials = {"ID: 1234     |     Name: Mail     |     user: luis@mail.com     |     Password: luis123",
                "ID: 5678     |     Name: Twitter     |     user: pepe     |     Password: pepetwitter123",
                "ID: 9123     |     Name: Google     |     user: alberto@gmail.com     |     Password: alberto123"};
        for (String credential : credentials) {
            View.listModelCredentials.addElement(credential);
        }
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
