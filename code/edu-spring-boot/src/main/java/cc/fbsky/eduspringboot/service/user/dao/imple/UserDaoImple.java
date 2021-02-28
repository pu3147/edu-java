package cc.fbsky.eduspringboot.service.user.dao.imple;

import cc.fbsky.eduspringboot.api.user.ao.UserAO;
import cc.fbsky.eduspringboot.service.user.dao.UserDao;
import cc.fbsky.eduspringboot.service.user.dao.entity.UserEntity;
import cc.fbsky.eduspringboot.service.user.dao.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImple implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(UserAO userAO){
        UserEntity dto = new UserEntity();
        BeanUtils.copyProperties(userAO,dto);

        userMapper.addUser(dto);
        return true;
    }
}
