package autowairedbean;

import com.sac.autowaired.IAnimal;
import com.sac.autowaired.scanconfig.AnimalScan;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author:eason
 * @Description：
 * @Date: 13:57,2018/1/17
 * @ModifiedBy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnimalScan.class)
public class Test {

    @Resource(name = "dogComponent")
    private IAnimal dog;

    @Resource(name = "catComponent")
    private IAnimal cat;

    @org.junit.Test
    public void dogTest() {
        dog.say();
        cat.say();
    }

}
