package org.fortun.credmandesk;

import org.fortun.credmandesk.httpClient.HTTPClientCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageCredential extends JFrame implements ActionListener {

    public ManageCredential() {

        View.manageCredential.setSize(400, 275);
        View.manageCredential.setResizable(false);
        View.manageCredential.setLayout(null);
        View.manageCredential.setLocationRelativeTo(null);
        View.manageCredential.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.manageCredential.setVisible(true);
        View.lblManageCredentialNameCredential.setBounds(50, 30, 100, 15);
        View.lblManageCredentialUserCredential.setBounds(50, 80, 100, 15);
        View.lblManageCredentialPasswordCredential.setBounds(50, 130, 100, 15);
        View.txtManageCredentialNameCredential.setBounds(175, 25, 150, 25);
        View.txtManageCredentialUserCredential.setBounds(175, 75, 150, 25);
        View.txtManageCredentialPasswordCredential.setBounds(175, 125, 150, 25);
        View.btnManageCredentialUpdate.setBounds(30, 175, 95, 30);
        View.btnManageCredentialDelete.setBounds(142, 175, 95, 30);
        View.btnManageCredentialCancel.setBounds(255, 175, 95, 30);
        View.btnManageCredentialUpdate.addActionListener(this);
        View.btnManageCredentialDelete.addActionListener(this);
        View.btnManageCredentialCancel.addActionListener(this);
        View.manageCredential.add(View.lblManageCredentialNameCredential);
        View.manageCredential.add(View.lblManageCredentialUserCredential);
        View.manageCredential.add(View.lblManageCredentialPasswordCredential);
        View.manageCredential.add(View.txtManageCredentialNameCredential);
        View.manageCredential.add(View.txtManageCredentialUserCredential);
        View.manageCredential.add(View.txtManageCredentialPasswordCredential);
        View.manageCredential.add(View.btnManageCredentialUpdate);
        View.manageCredential.add(View.btnManageCredentialDelete);
        View.manageCredential.add(View.btnManageCredentialCancel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(View.btnManageCredentialUpdate)) {
            if (View.txtManageCredentialNameCredential.getText().trim().length() > 0
                    && View.txtManageCredentialUserCredential.getText().trim().length() > 0
                    && View.txtManageCredentialPasswordCredential.getText().trim().length() > 0) {
                HTTPClientCredentials.update(Main.credential.getIdCredential().intValue(), View.txtManageCredentialNameCredential.getText(), View.txtManageCredentialUserCredential.getText(), View.txtManageCredentialPasswordCredential.getText(), Main.user.getIdUser().toString());
                JOptionPane.showMessageDialog(this, "Credential updated", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                View.listModelCredentials.removeAllElements();
                ArrayList<String> credentialsList = (ArrayList<String>) HTTPClientCredentials.read("findByUser", String.valueOf(Main.user.getIdUser())).clone();
                String[] credentials = credentialsList.toArray(new String[0]);
                for (String credential : credentials) {
                    View.listModelCredentials.addElement(credential);
                }

                View.manageCredential.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "You have not entered all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else if (actionEvent.getSource().equals(View.btnManageCredentialDelete)) {
            HTTPClientCredentials.delete(Main.credential.getIdCredential().intValue());
            JOptionPane.showMessageDialog(this, "Credential deleted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            View.listModelCredentials.removeAllElements();
            ArrayList<String> credentialsList = (ArrayList<String>) HTTPClientCredentials.read("findByUser", String.valueOf(Main.user.getIdUser())).clone();
            String[] credentials = credentialsList.toArray(new String[0]);
            for (String credential : credentials) {
                View.listModelCredentials.addElement(credential);
            }
            View.manageCredential.setVisible(false);
        } else if (actionEvent.getSource().equals(View.btnManageCredentialCancel)) {
            View.manageCredential.setVisible(false);
        }
    }
}
