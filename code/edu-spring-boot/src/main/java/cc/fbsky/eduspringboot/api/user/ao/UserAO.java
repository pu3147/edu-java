package cc.fbsky.eduspringboot.api.user.ao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserAO implements Serializable {

    private Integer  id;

    private String name;

    private String selfDesc;

    private Integer age;

    private Date birthday;

}
