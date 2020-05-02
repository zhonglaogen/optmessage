package cn.zlx.bs.service;

import cn.zlx.bs.bean.MessageFile;
import cn.zlx.bs.dto.MessageFileDto;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */


public interface MessageFileService {
     int newMessageFile(MessageFileDto mfd);
     
     List<MessageFile> findMessageFileByOid(Integer oId);

     List<MessageFile> findMessageFileByUid(MessageFileDto mfd);
}
