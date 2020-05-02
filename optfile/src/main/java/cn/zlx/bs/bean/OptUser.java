package cn.zlx.bs.bean;

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
public class OptUser {
    private Integer oid;
    private String name;
    private String email;
    private String reason;
    private String phone;
    private String password;
    private String canuse;

}
