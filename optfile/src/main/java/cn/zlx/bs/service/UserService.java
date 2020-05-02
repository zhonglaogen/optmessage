package cn.zlx.bs.service;

import cn.zlx.bs.bean.OptUser;
import cn.zlx.bs.dto.UserDto;
import cn.zlx.bs.result.Result;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */


public interface UserService {

    Result<OptUser> login(String email, String password);

    int regist(OptUser optUser);
}
