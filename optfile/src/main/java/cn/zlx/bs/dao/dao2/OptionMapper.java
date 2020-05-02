package cn.zlx.bs.dao.dao2;

import cn.zlx.bs.bean.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-10
 */

@Mapper
public interface OptionMapper {

    List<Option> getMessage();

    int insertMessage(Option option);
}
