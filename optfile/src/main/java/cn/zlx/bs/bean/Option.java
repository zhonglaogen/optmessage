package cn.zlx.bs.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {

    private Integer id;
    private String name;
    private String email;
    private String message;
    private String cretime;
}
