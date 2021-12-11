package DAO.Impl;

import DAO.UserDAO;
import pojo.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM player WHERE `username` = ? AND `password` = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO player (`username`,`password`,`email`) VALUE (?,?,?)";
        update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM player WHERE `username` = ?";
        return queryForOne(User.class,sql,username);
    }
}
