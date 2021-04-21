package org.fortun.credmandesk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ManageUser extends JFrame implements ActionListener {

    public ManageUser() {

        View.manageUser.setSize(400, 275);
        View.manageUser.setResizable(false);
        View.manageUser.setLayout(null);
        View.manageUser.setLocationRelativeTo(null);
        View.manageUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.manageUser.setVisible(true);
        View.lblManageUserNameUser.setBounds(50, 30, 100, 15);
        View.lblManageUserPasswordUser.setBounds(50, 80, 100, 15);
        View.lblManageUserPasswordUserAgain.setBounds(50, 130, 100, 15);
        View.txtManageUserNameUser.setBounds(175, 25, 150, 25);
        View.txtManageUserPasswordUser.setBounds(175, 75, 150, 25);
        View.txtManageUserPasswordUserAgain.setBounds(175, 125, 150, 25);
        View.btnManageUserUpdate.setBounds(30, 175, 95, 30);
        View.btnManageUserDelete.setBounds(142, 175, 95, 30);
        View.btnManageUserCancel.setBounds(255, 175, 95, 30);
        View.btnManageUserUpdate.addActionListener(this);
        View.btnManageUserDelete.addActionListener(this);
        View.btnManageUserCancel.addActionListener(this);
        View.manageUser.add(View.lblManageUserNameUser);
        View.manageUser.add(View.lblManageUserPasswordUser);
        View.manageUser.add(View.lblManageUserPasswordUserAgain);
        View.manageUser.add(View.txtManageUserNameUser);
        View.manageUser.add(View.txtManageUserPasswordUser);
        View.manageUser.add(View.txtManageUserPasswordUserAgain);
        View.manageUser.add(View.btnManageUserUpdate);
        View.manageUser.add(View.btnManageUserDelete);
        View.manageUser.add(View.btnManageUserCancel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(View.btnManageUserUpdate)) {
            if ((View.txtManageUserNameUser.getText().trim().length() > 0) && Arrays.equals(View.txtSignUpPasswordUser.getPassword(), View.txtSignUpPasswordUserAgain.getPassword())) {
                String passwordUser = new String(View.txtManageUserPasswordUser.getPassword());
                HTTPClient.update(Main.user.getIdUser().intValue(), View.txtManageUserNameUser.getText(), passwordUser);
                JOptionPane.showMessageDialog(this, "User updated", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                HTTPClient.read("findByName", View.txtManageUserNameUser.getText());
                View.txtManageUserNameUser.setText("");
                View.txtManageUserPasswordUser.setText("");
                View.txtManageUserPasswordUserAgain.setText("");
                View.manageUser.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "You have not entered the name or the passwords do not match", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else if (actionEvent.getSource().equals(View.btnManageUserDelete)) {
            HTTPClient.delete(Main.user.getIdUser().intValue());
            JOptionPane.showMessageDialog(this, "User deleted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            View.manageUser.setVisible(false);
            View.credentialManager.setVisible(false);
            View.login.setVisible(true);
        } else if (actionEvent.getSource().equals(View.btnManageUserCancel)) {
            View.manageUser.setVisible(false);
        }
    }
}
