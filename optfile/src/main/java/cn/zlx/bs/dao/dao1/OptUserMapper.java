package cn.zlx.bs.dao.dao1;

import cn.zlx.bs.bean.OptUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@Mapper
public interface OptUserMapper {
    /**
     * 通过邮箱查资料
     * @param email
     * @return
     */
    OptUser getUserByEmail(@Param("email") String email);

    /**
     * 注册账号
     */
    int insertUser(OptUser optUser);


}
