package cn.itcast.dao.Impl;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("Userdao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {

        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findbyid(Integer id) {
        try {
//            System.out.println(id);
            Account query = runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
//            System.out.println(query);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Account account) {
        String sql ="insert into account values(null,?,?)";
        try {
            runner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name = ? , money = ? where id  = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delect(Integer id) {
        try {
            runner.update("DELETE FROM account WHERE id = ? ", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
