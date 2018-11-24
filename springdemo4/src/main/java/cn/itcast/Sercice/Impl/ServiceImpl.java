package cn.itcast.Sercice.Impl;

import cn.itcast.Sercice.Service;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("Service")
public class ServiceImpl implements Service {
    @Autowired
    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<Account> findAll() {
        return userDao.findAll();
    }
    @Override
    public Account findbyid(Integer id) {
        return userDao.findbyid(id);
    }
    @Override
    public void save(Account account) {
        userDao.save(account);
    }
    @Override
    public void update(Account account) {
        userDao.update(account);
    }
    @Override
    public void delect(Integer id) {
        userDao.delect(id);
    }
}
