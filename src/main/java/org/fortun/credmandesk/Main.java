package org.fortun.credmandesk;

public class Main {
    public static void main(String[] args) {
        new Login();
        new SignUp();
        View.signUp.setVisible(false);
        new CredentialManager();
        View.credentialManager.setVisible(false);
        new ManageUser();
        View.manageUser.setVisible(false);
    }
}
