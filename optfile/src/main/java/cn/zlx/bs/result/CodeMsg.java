package cn.zlx.bs.result;

import cn.zlx.bs.dto.UserDto;
import org.springframework.util.ObjectUtils;

public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");

    public static CodeMsg NOT_FIND_USER = new CodeMsg(400101,"没有找到要建档的用户");
    public static CodeMsg REGIST_FAIL = new CodeMsg(400102,"注册失败,请检查邮箱是否已经注册");

    public static CodeMsg USER_IS_NOT_EXISTS = new CodeMsg(400103,"建档人不存在");

    public static CodeMsg ID_IS_NOT_EXISTS = new CodeMsg(400104,"账号不存在");
    public static CodeMsg ID_IS_WAIT_ACCEPT = new CodeMsg(400105,"等待审核");
    public static CodeMsg ID_IS_NOT_ACCEPT = new CodeMsg(400106,"审核未通过");
    public static CodeMsg LOGIN_ERROR = new CodeMsg(400107,"登录状态异常");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(400108,"密码错误");





    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
