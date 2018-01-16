package com.sac.quartz;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:eason
 * @Description
 * @Date: 22:33,2018/1/16
 * @ModifiedBy
 */
public class FirstScheduledJob extends QuartzJobBean {
    private AnotherBean anotherBean;

    public void setAnotherBean(AnotherBean anotherBean){
        this.anotherBean = anotherBean;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("FirstScheduledJob Executes!" + sf.format(date));
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        System.out.println("say hello to " + name + " at " + new Date());
        this.anotherBean.printAnotherMessage();
    }
}
