package cn.zlx.utils;

import cn.zlx.bs.mail.MyMailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @Description:
 * @author: zhonglianxi
 * @date: 2020-04-10
 */
public class MailSingle {
    private MailSingle(){}
    private ExecutorService executor = new ThreadPoolExecutor(
        5,10,60,TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    private static  class SingleHolder{
        private static MailSingle mailSingle = new MailSingle();
    }

    public static MailSingle getInstance(){
        return SingleHolder.mailSingle;
    }

    public void runTask(MyMailService mailService,String toEmail, String name, String title){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mailService.sendNotice(toEmail,name,title);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
