package cc.fbsky.eduspringboot.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    private String name;

    private Integer age;

    private Date birthday;

    private Date regestDay;
}
