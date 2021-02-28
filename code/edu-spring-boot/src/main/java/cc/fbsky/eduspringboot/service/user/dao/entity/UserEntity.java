package cc.fbsky.eduspringboot.service.user.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Integer  id;

    private String name;

    private String selDes;

    private Integer age;

    private Date birthday;

    private Date registryDay;
}
