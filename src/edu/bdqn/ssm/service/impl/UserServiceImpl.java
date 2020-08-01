package edu.bdqn.ssm.service.impl;

import edu.bdqn.ssm.dao.UserMapper;
import edu.bdqn.ssm.entity.User;
import edu.bdqn.ssm.service.UserService;
import edu.bdqn.ssm.util.Env;
import edu.bdqn.ssm.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(Map<String, Object> params) {
        return this.userMapper.login(params);
    }

    @Override
    public int saveUser(Map<String, Object> params) {
        return userMapper.saveUser(params);
    }


    @Override
    public Pager<User> loadUsersListPager(int currentPage) {
        // 获取表中全部数据传递给Pager对象的list属性
        // 查询全部用户信息
        List<User> users = this.userMapper.loadUser();
        // 获取配置文件中几条一页
        Integer pageSize = Integer.parseInt(Env.getInstance().getProperty(
                "pageSize"));
        //创建Pager对象
        Pager<User> pageInfo = new Pager<>(users.size(), currentPage, pageSize);

        // 判断是否是最后一页,如果最后一页就显示最后一页的几条数据，不是最后一页就显示pageSize条
        if (currentPage == pageInfo.getTotalPage())
            /////////////////////
            pageInfo.setList(users.subList((currentPage - 1) * pageSize,
                    users.size()));
        else
            pageInfo.setList(users.subList((currentPage - 1) * pageSize,
                    (currentPage - 1) * pageSize + pageSize));
        return pageInfo;
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }


}
