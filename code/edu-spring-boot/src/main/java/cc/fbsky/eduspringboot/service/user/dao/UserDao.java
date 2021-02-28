package cc.fbsky.eduspringboot.service.user.dao;

import cc.fbsky.eduspringboot.api.user.ao.UserAO;

public interface UserDao {
    boolean addUser(UserAO userAO);
}
