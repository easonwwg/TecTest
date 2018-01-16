### 知识点
     Scheduler：调度器。所有的调度都是由它控制。
     Trigger： 定义触发的条件。
     JobDetail & Job： JobDetail 定义的是任务数据，而真正的执行逻辑是在Job中，
     例子中是HelloQuartz
     为什么设计成JobDetail + Job，不直接使用Job？
     这是因为任务是有可能并发执行，如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。
     而JobDetail & Job 方式，sheduler每次执行，都会根据JobDetail创建一个新的Job实例，
     这样就可以规避并发访问的问题。
    
####Trigger实现类


     * SimpleTrigger
      
       指定从某一个时间开始，以一定的时间间隔（单位是毫秒）执行的任务。
       它适合的任务类似于：9:00 开始，每隔1小时，执行一次。
       它的属性有：
           repeatInterval 重复间隔
           repeatCount 重复次数。实际执行次数是 repeatCount+1。因为在startTime的时候一定会执行一次。** 下面有关repeatCount 属性的都是同理。　**

    *  CalendarIntervalTrigger
   
         CalendarIntervalTrigger支持的间隔单位有秒，分钟，小时，天，月，年，星期。
         相较于SimpleTrigger有两个优势：
         1、更方便，比如每隔1小时执行，你不用自己去计算1小时等于多少毫秒。 2、支持不是固定长度的间隔，比如间隔为月和年。但劣势是精度只能到秒。
         它适合的任务类似于：9:00 开始执行，并且以后每周 9:00 执行一次
         
        
    * DailyTimeIntervalTrigger
   
       指定每天的某个时间段内，以一定的时间间隔执行任务。并且它可以支持指定星期。
        它适合的任务类似于：指定每天9:00 至 18:00 ，每隔70秒执行一次，并且只要周一至周五执行。
        
        
    * CronTrigger(推荐，常用)
   
        适合于更复杂的任务，它支持类型于Linux Cron的语法（并且更强大）。基本上它覆盖了以上三个Trigger的绝大部分能力（但不是全部）—— 当然，也更难理解。
        它适合的任务类似于：每天0:00,9:00,18:00各执行一次。
        它的属性只有:
        Cron表达式。但这个表示式本身就够复杂了。下面会有说明。
        
        
        
####  JobDetail/Job
       JobDetail是任务的定义，而Job是任务的执行逻辑。
       在JobDetail里会引用一个Job Class定义。一个最简单的例子
       
   ~~~
   public class DoNothingJob implements Job {
       public void execute(JobExecutionContext context) throws JobExecutionException {
           System.out.println("do nothing");
       }
   }
   
      JobDetail job=newJob()
                  .ofType(DoNothingJob.class) //引用Job Class
                  .withIdentity("job1", "group1") //设置name/group
                  .withDescription("this is a test job") //设置描述
                  .usingJobData("age", 18) //加入属性到ageJobDataMap
                  .build();
   
              job.getJobDataMap().put("name", "quertz"); //加入属性name到JobDataMap
   
              //定义一个每秒执行一次的SimpleTrigger
              Trigger trigger=newTrigger()
                      .startNow()
                      .withIdentity("trigger1")
                      .withSchedule(simpleSchedule()
                          .withIntervalInSeconds(1)
                          .repeatForever())
                      .build();
   
              Scheduler sche=StdSchedulerFactory.getDefaultScheduler();
              sche.scheduleJob(job, trigger);
   
              sche.start();
   
              System.in.read();
   
              sche.shutdown();
       
   ~~~
      

#### JobDataMap
      Job都次都是newInstance的实例，那我怎么传值给它？
       比如我现在有两个发送邮件的任务，一个是发给"liLei",一个发给"hanmeimei",
       不能说我要写两个Job实现类LiLeiSendEmailJob和HanMeiMeiSendEmailJob。
       实现的办法是通过JobDataMap传值
       
~~~
 public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        JobDataMap map = detail.getJobDataMap(); //方法一：获得JobDataMap
        System.out.println("say hello to " + name + "[" + map.getInt("age") + "]" + " at "
                           + new Date());
    }
~~~


#### job并发
      job是有可能并发执行的，比如一个任务要执行10秒中，
      而调度算法是每秒中触发1次，
      那么就有可能多个任务被并发执行。
      有时候我们并不想任务并发执行,这个时候一个@DisallowConcurrentExecution解决这个问题。
       @DisallowConcurrentExecution
          public void execute(JobExecutionContext context) throws JobExecutionException {
              System.out.println("do nothing");
          }

#### Scheduler
        Scheduler就是Quartz的大脑，所有任务都是由它来设施。
        Schduelr包含一个两个重要组件: JobStore和ThreadPool。  
        JobStore是会来存储运行时信息的，包括Trigger,Schduler,JobDetail，业务锁等。它有多种实现RAMJob(内存实现)，JobStoreTX(JDBC，事务由Quartz管理），JobStoreCMT(JDBC，使用容器事务)，ClusteredJobStore(集群实现)、TerracottaJobStore(什么是Terractta)。
        ThreadPool就是线程池，Quartz有自己的线程池实现。所有任务的都会由线程池执行。
  

### Cronin表达式(百度有在线cron表达式工具)
     * * * * * ? *
     上是由七子表达式，描述个别细节的时间表。这些子表达式是分开的空白，代表：
     
         1.        Seconds
         2.        Minutes
         3.        Hours
         4.        Day-of-Month
         5.        Month
         6.        Day-of-Week
         7.        Year (可选字段)
         秒 分 时 日 月 周 年(可选)。
         
          字段名                 允许的值                        允许的特殊字符  
          秒                         0-59                            , - * /  
          分                         0-59                            , - * /  
          小时                       0-23                            , - * /  
          日                         1-31                            , - * ? / L W C  
          月                         1-12 or JAN-DEC                 , - * /  
          周几                       1-7 or SUN-SAT                   , - * ? / L C #  
          年 (可选字段)              empty, 1970-2099                   , - * /
              
              
              
          “?”字符：表示不确定的值
          “,”字符：指定数个值
          “-”字符：指定一个值的范围
          “/”字符：指定一个值的增加幅度。n/m表示从n开始，每次增加m
          “L”字符：用在日表示一个月中的最后一天，用在周表示该月最后一个星期X
          “W”字符：指定离给定日期最近的工作日(周一到周五)
          “#”字符：表示该月第几个周X。6#3表示该月第3个周五
     
     2）Cron表达式范例：
     
           每隔5秒执行一次：*/5 * * * * ?
     
           每隔1分钟执行一次：0 */1 * * * ?
     
           每天23点执行一次：0 0 23 * * ?
     
           每天凌晨1点执行一次：0 0 1 * * ?
     
           每月1号凌晨1点执行一次：0 0 1 1 * ?
     
           每月最后一天23点执行一次：0 0 23 L * ?
     
           每周星期天凌晨1点实行一次：0 0 1 ? * L
     
           在26分、29分、33分执行一次：0 26,29,33 * * * ?
     
           每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
           
           
#### scheduler
       *  StdSchedulerFactory
       
       *  DirectSchedulerFactory