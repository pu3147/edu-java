package cc.fbsky.eduspringboot.service.user;

import cc.fbsky.eduspringboot.api.user.UserManagerService;
import cc.fbsky.eduspringboot.api.user.ao.UserAO;
import cc.fbsky.eduspringboot.base.BaseResult;
import cc.fbsky.eduspringboot.service.user.dao.UserDao;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserManagerServiceImple implements UserManagerService {

    @Autowired
    private UserDao userDao;

    @Override
    public BaseResult addUser(UserAO userInfo) {
        if(log.isDebugEnabled()){
            log.debug("addUser,userInfo"+ JSON.toJSONString(userInfo));
        }
        boolean isSuccess = userDao.addUser(userInfo);

        return  new BaseResult();
    }
}
