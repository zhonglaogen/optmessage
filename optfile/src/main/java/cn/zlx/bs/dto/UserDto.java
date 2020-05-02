package cn.zlx.bs.dto;

import cn.zlx.bs.bean.OptUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private OptUser optUser;
    private String code;
    private String msg;

}
