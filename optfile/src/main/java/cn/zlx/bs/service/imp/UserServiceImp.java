package cn.zlx.bs.service.imp;

import cn.zlx.bs.bean.OptUser;
import cn.zlx.bs.dao.dao1.OptUserMapper;
import cn.zlx.bs.dto.UserDto;
import cn.zlx.bs.result.CodeMsg;
import cn.zlx.bs.result.Result;
import cn.zlx.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    OptUserMapper optUserMapper;

    @Override
    public Result<OptUser> login(String email, String password) {
        OptUser userByEmail = optUserMapper.getUserByEmail(email);
        if (ObjectUtils.isEmpty(userByEmail)){
//            账号不存在
            return Result.error(CodeMsg.ID_IS_NOT_EXISTS);
        }
        if (password.equals(userByEmail.getPassword())){
            String canuse = userByEmail.getCanuse();
            if ("wait".equals(canuse)){
//                等待审核
                return Result.error(CodeMsg.ID_IS_WAIT_ACCEPT);
            }else if ("no".equals(canuse)){
//                审核未通过
                return Result.error(CodeMsg.ID_IS_NOT_ACCEPT);
            }else if ("yes".equals(canuse)){
                userByEmail.setPassword("");
//                登录成功
                return Result.success(userByEmail);
            }else {
//                登录状态异常
                return Result.error(CodeMsg.LOGIN_ERROR);
            }
        }
//        密码错误
        return Result.error(CodeMsg.PASSWORD_ERROR);
    }

    @Override
    public int regist(OptUser optUser) {
        try {
            int i = optUserMapper.insertUser(optUser);
            optUser.setPassword("");
             return i;
        }catch (Exception e){
//            检查邮箱是否已经注册
            return 0;
        }

    }
}
