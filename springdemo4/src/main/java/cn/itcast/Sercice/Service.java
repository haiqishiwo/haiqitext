package cn.itcast.Sercice;

import cn.itcast.pojo.Account;

import java.util.List;

public interface Service {
    List<Account> findAll();
    Account findbyid(Integer id);
    void save(Account account);
    void update(Account account);
    void delect(Integer id);
}
