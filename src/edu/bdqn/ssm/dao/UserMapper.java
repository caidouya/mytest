package edu.bdqn.ssm.dao;

import edu.bdqn.ssm.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public int login(Map<String ,Object> params);
    public List<User> loadUser();
    public int saveUser(Map<String ,Object> params);
    public int delete(Integer id);
}
