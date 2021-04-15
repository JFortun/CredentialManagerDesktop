package org.fortun.credmandesk;

import javax.swing.*;

public class View {

    // Login
    static JFrame login = new JFrame("Login");
    static JLabel lblLoginNameUser = new JLabel("User name");
    static JLabel lblLoginPasswordUser = new JLabel("Password");
    static JTextField txtLoginNameUser = new JTextField();
    static JPasswordField txtLoginPasswordUser = new JPasswordField();
    static JButton btnLoginSignIn = new JButton("Sign In");
    static JButton btnLoginSignUp = new JButton("Sign Up");

    // Sign In
    static JFrame signUp = new JFrame("Sign Up");
    static JLabel lblSignUpNameUser = new JLabel("User name");
    static JLabel lblSignUpPasswordUser = new JLabel("Password");
    static JLabel lblSignUpPasswordUserAgain = new JLabel("Repeat password");
    static JTextField txtSignUpNameUser = new JTextField();
    static JPasswordField txtSignUpPasswordUser = new JPasswordField();
    static JPasswordField txtSignUpPasswordUserAgain = new JPasswordField();
    static JButton btnSignUp = new JButton("Sign Up");
    static JButton btnSignUpCancel = new JButton("Cancel");
}
