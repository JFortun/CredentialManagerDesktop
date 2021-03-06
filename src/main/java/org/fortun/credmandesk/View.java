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

    // Sign Up
    static JFrame signUp = new JFrame("Sign Up");
    static JLabel lblSignUpNameUser = new JLabel("User name");
    static JLabel lblSignUpPasswordUser = new JLabel("Password");
    static JLabel lblSignUpPasswordUserAgain = new JLabel("Repeat password");
    static JTextField txtSignUpNameUser = new JTextField();
    static JPasswordField txtSignUpPasswordUser = new JPasswordField();
    static JPasswordField txtSignUpPasswordUserAgain = new JPasswordField();
    static JButton btnSignUp = new JButton("Sign Up");
    static JButton btnSignUpCancel = new JButton("Cancel");

    // Credential Manager
    static JFrame credentialManager = new JFrame("Credential Manager");
    static JLabel lblCredentialManagerListHeader = new JLabel("ID          -          NAME          -          USER          -          PASSWORD");
    static JButton btnCredentialManagerManageUser = new JButton("Manage User");
    static JButton btnCredentialManagerSignOut = new JButton("Sign Out");
    static JButton btnCredentialManagerCreate = new JButton("Create");
    static JButton btnCredentialManagerManageCredential = new JButton("Manage Credential");
    static DefaultListModel<String> listModelCredentials = new DefaultListModel<>();
    static JList<String> listCredentials = new JList(listModelCredentials);
    static JScrollPane scrollPaneCredentials = new JScrollPane(listCredentials);

    // Manage User
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

    // Manage Credential
    static JFrame manageCredential = new JFrame("Manage Credential");
    static JLabel lblManageCredentialNameCredential = new JLabel("Credential name");
    static JLabel lblManageCredentialUserCredential = new JLabel("User");
    static JLabel lblManageCredentialPasswordCredential = new JLabel("Password");
    static JTextField txtManageCredentialNameCredential = new JTextField();
    static JTextField txtManageCredentialUserCredential = new JTextField();
    static JTextField txtManageCredentialPasswordCredential = new JTextField();
    static JButton btnManageCredentialUpdate = new JButton("Update");
    static JButton btnManageCredentialDelete = new JButton("Delete");
    static JButton btnManageCredentialCancel = new JButton("Cancel");
}
