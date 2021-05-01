package org.fortun.credmandesk;

import org.fortun.credmandesk.httpClient.HTTPClientCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CredentialManager extends JFrame implements ActionListener {

    public CredentialManager() {

        View.credentialManager.setSize(900, 600);
        View.credentialManager.setResizable(false);
        View.credentialManager.setLayout(null);
        View.credentialManager.setLocationRelativeTo(null);
        View.credentialManager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.credentialManager.setVisible(true);
        View.lblCredentialManagerListHeader.setBounds(50, 100, 400, 30);
        View.btnCredentialManagerManageUser.setBounds(530, 25, 120, 30);
        View.btnCredentialManagerSignOut.setBounds(50, 25, 95, 30);
        View.btnCredentialManagerCreate.setBounds(665, 200, 200, 50);
        View.btnCredentialManagerManageCredential.setBounds(665, 300, 200, 50);
        View.scrollPaneCredentials.setBounds(50, 125, 600, 400);
        View.scrollPaneCredentials.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        View.btnCredentialManagerManageUser.addActionListener(this);
        View.btnCredentialManagerSignOut.addActionListener(this);
        View.btnCredentialManagerCreate.addActionListener(this);
        View.btnCredentialManagerManageCredential.addActionListener(this);
        View.credentialManager.add(View.lblCredentialManagerListHeader);
        View.credentialManager.add(View.btnCredentialManagerManageUser);
        View.credentialManager.add(View.btnCredentialManagerSignOut);
        View.credentialManager.add(View.btnCredentialManagerCreate);
        View.credentialManager.add(View.btnCredentialManagerManageCredential);
        View.credentialManager.add(View.scrollPaneCredentials);
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
        } else if (actionEvent.getSource().equals(View.btnCredentialManagerCreate)) {
            JTextField nameCredential = new JTextField();
            JTextField userCredential = new JTextField();
            JTextField passwordCredential = new JTextField();
            Object[] message = {
                    "nameCredential:", nameCredential,
                    "userCredential:", userCredential,
                    "passwordCredential:", passwordCredential
            };

            int option = JOptionPane.showConfirmDialog(null, message, "New credential", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                HTTPClientCredentials.create(nameCredential.getText(), userCredential.getText(), passwordCredential.getText(), String.valueOf(Main.user.getIdUser()));
                JOptionPane.showMessageDialog(this, "Credential created", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }

            View.listModelCredentials.removeAllElements();
            ArrayList<String> credentialsList = (ArrayList<String>) HTTPClientCredentials.read("findByUser", String.valueOf(Main.user.getIdUser())).clone();
            String[] credentials = credentialsList.toArray(new String[0]);
            for (String credential : credentials) {
                View.listModelCredentials.addElement(credential);
            }
        } else if (actionEvent.getSource().equals(View.btnCredentialManagerManageCredential)) {
            if (!View.listCredentials.isSelectionEmpty()) {
                String selected = View.listCredentials.getSelectedValue();
                String[] selectedSplit = selected.split("          -          ");
                Main.credential.setIdCredential(Long.valueOf(selectedSplit[0]));
                View.txtManageCredentialNameCredential.setText(selectedSplit[1]);
                View.txtManageCredentialUserCredential.setText(selectedSplit[2]);
                View.txtManageCredentialPasswordCredential.setText(selectedSplit[3]);
                View.manageCredential.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "You have select a credential", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        }
    }
}
