package cc.fbsky.eduspringboot.web.user.controller;

import cc.fbsky.eduspringboot.api.user.UserManagerService;
import cc.fbsky.eduspringboot.base.BaseResult;
import cc.fbsky.eduspringboot.api.user.ao.UserAO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserManagerService userManagerService;

    @ApiOperation("新增用户")
    @PostMapping("/user/add")
    public BaseResult addUser(@RequestBody UserAO useInfo){
        return  userManagerService.addUser(useInfo);
    }

}
