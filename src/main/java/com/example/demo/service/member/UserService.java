package com.example.demo.service.member;


import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

/**
 * @author hjwforever
 * @date 12/03/2021 6:53 PM
 */

public interface UserService {
    void save(User User);//保存用户
    Page<User> PageByUser(Integer page, Integer size);//对用户数据进行分页
}
