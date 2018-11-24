import cn.itcast.Config.AConfig;
import cn.itcast.Sercice.Impl.ServiceImpl;
import cn.itcast.Sercice.Service;
import cn.itcast.pojo.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AConfig.class)
public class test01 {
    @Autowired
    private  Service service;

    @Test
    public void Test01(){
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
