package cc.fbsky.eduspringboot.user.controller;

import cc.fbsky.eduspringboot.common.BaseResult;
import cc.fbsky.eduspringboot.user.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @ApiOperation("新增用户")
    @PostMapping("/user/add")
    public BaseResult addUser(@RequestBody UserVO useInfo){
        return  new BaseResult();
    }
}
