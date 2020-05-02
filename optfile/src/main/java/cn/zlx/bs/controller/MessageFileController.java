package cn.zlx.bs.controller;

import cn.zlx.bs.bean.MessageFile;
import cn.zlx.bs.dto.MessageFileDto;
import cn.zlx.bs.dto.Test;
import cn.zlx.bs.result.CodeMsg;
import cn.zlx.bs.result.Result;
import cn.zlx.bs.service.MessageFileService;
import com.alibaba.fastjson.JSONObject;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-09
 */
@RestController
@RequestMapping("/message")
public class MessageFileController {

    @Autowired
    MessageFileService messageFileService;

    @PostMapping("/insertfile")
    public Result<MessageFileDto> insertFile(@RequestBody MessageFileDto messageFileDto){
        int i = messageFileService.newMessageFile(messageFileDto);
        if (i == -1){
            return Result.error(CodeMsg.USER_IS_NOT_EXISTS);
        }
        return Result.success(messageFileDto);
    }

    @GetMapping("/test")
    public Result test( Test obj){
        int a = 0;

        return null;
    }

    @GetMapping("/history")
    public Result<List<MessageFile>> getHistory(Integer oid){
        List<MessageFile> messageFileByOid = messageFileService.findMessageFileByOid(oid);
        return Result.success(messageFileByOid);
    }

    @PostMapping("/usermsg")
    public Result<List<MessageFile>> usermsg(@RequestBody MessageFileDto mfd){
        List<MessageFile> messageFileByOid = messageFileService.findMessageFileByUid(mfd);
        return Result.success(messageFileByOid);
    }
}
