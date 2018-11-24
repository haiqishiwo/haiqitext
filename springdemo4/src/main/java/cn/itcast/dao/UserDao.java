package cn.itcast.dao;

import cn.itcast.pojo.Account;

import java.util.List;

public interface UserDao {

    List<Account> findAll();//查询所有

    Account findbyid(Integer id);//根据id查询一条数据

    void save(Account account); //保存数据

    void update(Account account); //更改数据

    void delect(Integer id);//根据id删除数据


}
