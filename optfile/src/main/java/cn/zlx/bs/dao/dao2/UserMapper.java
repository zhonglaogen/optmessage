package cn.zlx.bs.dao.dao2;


import cn.zlx.bs.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */

@Mapper
public interface UserMapper {
    List<User> getUser();

    User findUserByEmailAndIdCard(@Param("email") String email, @Param("card") String idCard);
}
