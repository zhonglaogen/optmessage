package cn.zlx.bs.service.imp;

import cn.zlx.bs.bean.MessageFile;
import cn.zlx.bs.bean.User;
import cn.zlx.bs.dao.dao1.MessageFileMapper;
import cn.zlx.bs.dao.dao2.UserMapper;
import cn.zlx.bs.dto.MessageFileDto;
import cn.zlx.bs.mail.MyMailService;
import cn.zlx.bs.result.CodeMsg;
import cn.zlx.bs.result.Result;
import cn.zlx.bs.service.MessageFileService;
import cn.zlx.utils.MailSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@Service
public class MessageFileServiceImp implements MessageFileService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MessageFileMapper messageFileMapper;
    @Autowired
    MyMailService mailService;

    MailSingle mailSingle = MailSingle.getInstance();
    
    @Override
    public int newMessageFile(MessageFileDto mfd) {
//        查询新建档案人是否存在
        User userByEmailAndIdCard = userMapper.findUserByEmailAndIdCard(mfd.getEmail(), mfd.getIdCard());
        if (userByEmailAndIdCard == null){
            return -1;
        }
        MessageFile messageFile = mfd.getMessageFile();
        messageFile.setUid(userByEmailAndIdCard.getId());

        Integer integer = messageFileMapper.insetFile(messageFile);

        if (integer.equals(1) && "已通知".equals(messageFile.getAddvise())){
            mailSingle.runTask(mailService,userByEmailAndIdCard.getEmail(),
                    messageFile.getOname(),
                    messageFile.getTitle());
        }
        return integer;

    }

    /**
     * 查询历史添加的档案
     * @param oId
     * @return
     */
    @Override
    public List<MessageFile> findMessageFileByOid(Integer oId) {
        return messageFileMapper.findHistoryInsert(oId);
    }

    /**
     * 查询某人的档案
     * @param mfd
     * @return
     */
    @Override
    public List<MessageFile> findMessageFileByUid(MessageFileDto mfd) {
//        通过email和idcard查询这个人
//        在通过人id查询档案
        User userByEmailAndIdCard = userMapper.findUserByEmailAndIdCard(mfd.getEmail(), mfd.getIdCard());
        if (userByEmailAndIdCard == null){
            return null;
        }
        return messageFileMapper.findUserAllFile(userByEmailAndIdCard.getId());
    }


}
