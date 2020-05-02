package cn.zlx.bs.dto;

import cn.zlx.bs.bean.MessageFile;
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
public class MessageFileDto {

    private MessageFile messageFile;
    private String idCard;
    private String email;
}
