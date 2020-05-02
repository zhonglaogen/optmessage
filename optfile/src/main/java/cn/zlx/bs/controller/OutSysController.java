package cn.zlx.bs.controller;

import cn.zlx.bs.bean.Option;
import cn.zlx.bs.dao.dao2.OptionMapper;
import cn.zlx.bs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-10
 */
@RestController
@RequestMapping("/out")
public class OutSysController {

    @Autowired
    OptionMapper optionMapper;

    @GetMapping("/showMSg")
    public Result<List<Option>> getMsg(){

        List<Option> message = optionMapper.getMessage();
        return Result.success(message);
    }

    @PostMapping("/creMSg")
    public Result<Integer> creMsg(@RequestBody Option option){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        option.setCretime(dtf2.format(currentTime));
        Integer res = optionMapper.insertMessage(option);
        return Result.success(res);
    }
}
