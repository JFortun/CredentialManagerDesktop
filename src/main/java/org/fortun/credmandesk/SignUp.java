package org.fortun.credmandesk;

import org.fortun.credmandesk.httpClient.HTTPClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUp extends JFrame implements ActionListener {

    public SignUp() {

        View.signUp.setSize(400, 275);
        View.signUp.setResizable(false);
        View.signUp.setLayout(null);
        View.signUp.setLocationRelativeTo(null);
        View.signUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        View.signUp.setVisible(true);
        View.lblSignUpNameUser.setBounds(50, 30, 100, 15);
        View.lblSignUpPasswordUser.setBounds(50, 80, 100, 15);
        View.lblSignUpPasswordUserAgain.setBounds(50, 130, 100, 15);
        View.txtSignUpNameUser.setBounds(175, 25, 150, 25);
        View.txtSignUpPasswordUser.setBounds(175, 75, 150, 25);
        View.txtSignUpPasswordUserAgain.setBounds(175, 125, 150, 25);
        View.btnSignUp.setBounds(50, 175, 95, 30);
        View.btnSignUpCancel.setBounds(235, 175, 95, 30);
        View.btnSignUp.addActionListener(this);
        View.btnSignUpCancel.addActionListener(this);
        View.signUp.add(View.lblSignUpNameUser);
        View.signUp.add(View.lblSignUpPasswordUser);
        View.signUp.add(View.lblSignUpPasswordUserAgain);
        View.signUp.add(View.txtSignUpNameUser);
        View.signUp.add(View.txtSignUpPasswordUser);
        View.signUp.add(View.txtSignUpPasswordUserAgain);
        View.signUp.add(View.btnSignUp);
        View.signUp.add(View.btnSignUpCancel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(View.btnSignUp)) {
            if ((View.txtSignUpNameUser.getText().trim().length() > 0) && Arrays.equals(View.txtSignUpPasswordUser.getPassword(), View.txtSignUpPasswordUserAgain.getPassword())) {
                String passwordUser = new String(View.txtSignUpPasswordUser.getPassword());
                HTTPClient.create(View.txtSignUpNameUser.getText(), passwordUser);
                JOptionPane.showMessageDialog(this, "User signed up", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                View.txtSignUpNameUser.setText("");
                View.txtSignUpPasswordUser.setText("");
                View.txtSignUpPasswordUserAgain.setText("");
                View.signUp.setVisible(false);
                View.login.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "You have not entered the name or the passwords do not match", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else if (actionEvent.getSource().equals(View.btnSignUpCancel)) {
            View.signUp.setVisible(false);
            View.login.setVisible(true);
        }
    }
}
