package service.Impl;

import DAO.Impl.UserDAOImpl;
import DAO.UserDAO;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDAO userDAO = new UserDAOImpl();


    @Override
    public User login(String username, String password) {
        return userDAO.queryUserByUsernameAndPassword(username,password);
    }

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public boolean existName(String username) {
        User user = userDAO.queryUserByUsername(username);
        if(user == null)
            return false;
        else
            return true;
    }
}
