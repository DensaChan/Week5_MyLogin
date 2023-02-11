package manager;

import models.User;

/**
 *
 * @author Densa
 */
public class AccountService {
    public User login(String username, String password) {
        if (username.equals("abe") || (username.equals("barb")) && (password.equals("password")) )
            return new User(username, null);
        return null;
    }
}
