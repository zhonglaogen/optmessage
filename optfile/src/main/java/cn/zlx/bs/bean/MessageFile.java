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
public class MessageFile {

    private Integer fid;
    private String title;
//    建档类型(工作经历,成长经历)
    private String region;
    private String fdate;
    private String ftime;
//    是否通知
    private String addvise;
//    档案来源纸(质资料,电子文档,亲友访问,现实接触)
    private String types;
//    本人是否在场
    private String enviroment;
//    档案内容
    private String descri;
    private String oname;
    private String uname;
    private Integer oid;
    private Integer uid;

}
