package com.sac.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
/**
 * @author:eason
 * @Description：
 * @Date: 14:53,2018/1/16
 * @ModifiedBy
 */
public class QuartzTest {
    public static void main(String[] args) {

        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //定义一个Trigger
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
                    .startNow()//一旦加入scheduler，立即生效
                    .withSchedule(simpleSchedule() //使用SimpleTrigger
                            .withIntervalInSeconds(1) //每隔一秒执行一次
                            .repeatForever()) //一直执行，奔腾到老不停歇
                    .build();
            //定义一个JobDetail
            JobDetail job = newJob(new Job() {
                @Override
                public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
                    JobDetail detail = jobExecutionContext.getJobDetail();
                    String name = detail.getJobDataMap().getString("name");
                    System.out.println("say hello to " + name + " at " + new Date());
                }
            }.getClass()).withIdentity("job1", "group1") //定义name/group
                    .usingJobData("name", "wwg") //定义属性
                    .build();
            //加入这个调度
            scheduler.scheduleJob(job, trigger);
            //启动
            scheduler.start();
            System.out.println("启动成功");
            //在一分钟之后关闭
            Thread.sleep(10000);
            System.out.println("即将关闭");
            //关闭任务
            scheduler.shutdown(true);

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


