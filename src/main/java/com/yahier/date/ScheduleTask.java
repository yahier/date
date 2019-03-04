package com.yahier.date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务 与 间隔任务 相关
 */
@Component
public class ScheduleTask {

    /**
     * 每30秒钟 执行一次 测试 ok
     */
    //@Scheduled(fixedRate = 1000 * 30)
    public void test1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("方法2：" + dateFormat.format(new Date()));
    }

    /**
     * 每周四的18:00执行的 推荐有缘人
     */
    @Scheduled(cron = "0 0 18 ? * THU")
    public void recommendMate() {
        System.out.println("周四任务启动了");
        // 准备推荐有缘人了
        //1.获取所有愿意被推荐的男性列表，女性列表
        //2.针对每一个用户的条件，查询合适的异性，如果之前已经相互推荐，则跳过，继续寻找下一个人
        //3.调用微信接口，给找到有缘人的用户发送 ta的本周有缘人


    }
}
