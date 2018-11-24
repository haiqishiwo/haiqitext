package cn.itcast.ui;

import cn.itcast.Config.AConfig;
import cn.itcast.Sercice.Impl.ServiceImpl;
import cn.itcast.Sercice.Service;
import cn.itcast.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Sercvlect {
    public static void main(String[] args) {
//        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AConfig.class);
        Service service = (ServiceImpl)applicationContext.getBean("Service");
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        System.out.println("------------");
        Account findbyid = service.findbyid(1);
        System.out.println(findbyid);
        System.out.println("------------");
//        save(service);
//        delect(service);
//        set(service);
    }

    public static void save(Service service){
        Account account = new Account();
        account.setName("李小龙");
        account.setMoney(5555);
        service.save(account);
    }
    public static void set(Service service){
        Account account = new Account();
        account.setId(2);
        account.setName("李小龙");
        account.setMoney(8555);
        service.update(account);

    }
    public static void delect(Service service){
      service.delect(5);
    }




}
