package org.fortun.credmandesk;

import org.fortun.credmandesk.entity.User;

public class Main {

    static User user = new User();

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
