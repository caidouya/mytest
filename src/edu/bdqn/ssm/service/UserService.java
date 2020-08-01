package edu.bdqn.ssm.service;

import edu.bdqn.ssm.entity.User;
import edu.bdqn.ssm.util.Pager;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int login(Map<String ,Object> params);

    public int saveUser(Map<String ,Object> params);
    //3在业务逻辑
    public Pager<User> loadUsersListPager(int currentPage);

    public int delete(Integer id);
}
