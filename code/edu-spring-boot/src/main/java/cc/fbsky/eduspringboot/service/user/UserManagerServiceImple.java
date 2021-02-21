package cc.fbsky.eduspringboot.service.user;

import cc.fbsky.eduspringboot.api.user.UserManagerService;
import cc.fbsky.eduspringboot.api.user.ao.UserAO;
import cc.fbsky.eduspringboot.base.BaseResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserManagerServiceImple implements UserManagerService {

    @Override
    public BaseResult addUser(UserAO userInfo) {
        if(log.isDebugEnabled()){
            log.debug("addUser,userInfo"+ JSON.toJSONString(userInfo));
        }

        return new BaseResult();
    }
}
