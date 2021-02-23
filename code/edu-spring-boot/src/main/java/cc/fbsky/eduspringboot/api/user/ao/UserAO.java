package cc.fbsky.eduspringboot.api.user.ao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserAO implements Serializable {

    private String  id;

    private String name;

    private Integer age;

    private Date birthday;

    private Date registryDay;
}
