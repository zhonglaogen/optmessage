package cn.zlx.bs.controller;

import cn.zlx.bs.bean.OptUser;
import cn.zlx.bs.bean.User;
import cn.zlx.bs.dao.dao1.OptUserMapper;
import cn.zlx.bs.dao.dao2.UserMapper;
import cn.zlx.bs.dto.UserDto;
import cn.zlx.bs.result.CodeMsg;
import cn.zlx.bs.result.Result;
import cn.zlx.bs.service.MessageFileService;
import cn.zlx.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@RestController
@RequestMapping("/ouser")
public class OptUserController {

    @Autowired
    UserService userService;
    @Autowired
    MessageFileService messageFileService;


    @GetMapping("/login")
    public Result<OptUser> userLogin(OptUser optUser){

        return userService.login(optUser.getEmail(),optUser.getPassword());
    }

    @PostMapping("/regist")
    public Result<OptUser> userRegist(OptUser optUser){
        int regist = userService.regist(optUser);
        if (regist == 0){
//            注册失败
            return Result.error(CodeMsg.REGIST_FAIL);
        }
        return Result.success(optUser);
    }


}
