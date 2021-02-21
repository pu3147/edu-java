package cc.fbsky.eduspringboot.api.user;

import cc.fbsky.eduspringboot.api.user.ao.UserAO;
import cc.fbsky.eduspringboot.base.BaseResult;

public interface UserManagerService {
    BaseResult addUser(UserAO userInfo);
}
