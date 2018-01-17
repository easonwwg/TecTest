package quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author:eason
 * @Description：
 * @Date: 16:29,2018/1/15
 * @ModifiedBy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring-web.xml","classpath:applicationContext-service.xml"})
public class hello {
    /**
     * 测试quartz
     * @throws InterruptedException
     */
    @Test
    public void evaluatesExpression() throws InterruptedException {
       while (true){

       }
    }
}
