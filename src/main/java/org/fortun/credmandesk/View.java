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

    // Login
    static JFrame credentialManager = new JFrame("Credential Manager");
    static JButton btnCredentialManagerManageUser = new JButton("Manage User");
    static JButton btnCredentialManagerSignOut = new JButton("Sign Out");

    // Login
    static JFrame manageUser = new JFrame("Manage User");
    static JLabel lblManageUserNameUser = new JLabel("User name");
    static JLabel lblManageUserPasswordUser = new JLabel("Password");
    static JLabel lblManageUserPasswordUserAgain = new JLabel("Repeat password");
    static JTextField txtManageUserNameUser = new JTextField();
    static JPasswordField txtManageUserPasswordUser = new JPasswordField();
    static JPasswordField txtManageUserPasswordUserAgain = new JPasswordField();
    static JButton btnManageUserUpdate = new JButton("Update");
    static JButton btnManageUserDelete = new JButton("Delete");
    static JButton btnManageUserCancel = new JButton("Cancel");
}
