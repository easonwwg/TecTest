package com.sac.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author:eason
 * @Description：
 * @Date: 14:53,2018/1/16
 * @ModifiedBy
 */
public class QuartzTest {
    public static void main(String[] args) {

        try {
            //创建scheduler  调度器。所有的调度都是由它控制。
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //定义一个Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    //定义name/group  注意这里的组和下面任务的组不是一个
                    .withIdentity("trigger1", "group1")
                    //一旦加入scheduler，立即生效
                    .startNow()
                    //使用SimpleTrigger
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            //每隔一秒执行一次
                            .withIntervalInSeconds(6)
                            //一直执行，奔腾到老不停歇
                            // .repeatForever()
                            .withRepeatCount(3)
                    )
                    .build();

            //定义一个JobDetail
            //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
            JobDetail job = JobBuilder.newJob(HelloQuartz.class)
                    //定义name/group
                    .withIdentity("job1", "group1")
                    //定义属性
                    .usingJobData("name", "quartz")
                    .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);
            //启动之
            scheduler.start();
            //运行一段时间后关闭
            Thread.sleep(60000);
            //true 表示等待任务完成再关闭
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


