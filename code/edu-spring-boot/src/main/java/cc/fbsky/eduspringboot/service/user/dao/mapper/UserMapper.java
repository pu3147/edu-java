package cc.fbsky.eduspringboot.service.user.dao.mapper;

import cc.fbsky.eduspringboot.service.user.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void addUser(UserEntity dto);
}
