package DAO;

import pojo.User;

public interface UserDAO {

    User queryUserByUsernameAndPassword(String username, String password);

    void saveUser(User user);

    User queryUserByUsername(String username);
}
