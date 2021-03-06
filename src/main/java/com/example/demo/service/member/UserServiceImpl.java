package com.example.demo.service.member;


import com.example.demo.entity.User;
import com.example.demo.repository.member.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author hjwforever
 * @date 12/03/2021 6:53 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> PageByUser(Integer page, Integer size) {
        Pageable pageable =  PageRequest.of(page,size, Sort.Direction.ASC, "id");
        return userRepository.findAll(pageable);
    }
}
