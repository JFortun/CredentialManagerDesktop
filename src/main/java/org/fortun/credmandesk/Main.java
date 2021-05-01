package org.fortun.credmandesk;

import org.fortun.credmandesk.entity.Credential;
import org.fortun.credmandesk.entity.User;

public class Main {

    public static User user = new User();
    public static Credential credential = new Credential();

    public static void main(String[] args) {
        new Login();
        new SignUp();
        View.signUp.setVisible(false);
        new CredentialManager();
        View.credentialManager.setVisible(false);
        new ManageUser();
        View.manageUser.setVisible(false);
        new ManageCredential();
        View.manageCredential.setVisible(false);
    }
}
