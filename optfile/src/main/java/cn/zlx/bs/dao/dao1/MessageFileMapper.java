package cn.zlx.bs.dao.dao1;

import cn.zlx.bs.bean.MessageFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */

@Mapper
public interface MessageFileMapper {
    /**
     * 查历史添加
     * @param oid
     * @return
     */
    List<MessageFile> findHistoryInsert(Integer oid);

    /**
     * 通过uid查某人档案
     * @param uid
     * @return
     */
    List<MessageFile> findUserAllFile(Integer uid);

    /**
     * 插入档案
     * @param messageFile
     * @return
     */
    Integer insetFile(MessageFile messageFile);
}
