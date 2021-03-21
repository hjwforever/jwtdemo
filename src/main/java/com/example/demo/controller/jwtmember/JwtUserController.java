package com.example.demo.controller.jwtmember;

import com.example.demo.controller.BaseController;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.member.UserRoleRepository;
import com.example.demo.util.theDateUtils;
import com.example.demo.util.result.ExceptionMsg;
import com.example.demo.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjwforever
 * @date 12/03/2021 6:53 PM
 */

@RestController
@RequestMapping("jwt")
public class JwtUserController extends BaseController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @RequestMapping(value = "/register/mobile", method = RequestMethod.POST)
    public Response regist(User user) {
        logger.debug(user.toString());
        System.out.println(user.toString());

        try {
            if (user.getName() != null) {
                User userName = userRepository.findByName(user.getName());
                //  System.out.println("userName = " + userName);
                if (null != userName) {
                    return result(ExceptionMsg.UserNameUsed);
                }
            }
            else {
                return result(ExceptionMsg.UserNameEmpty);
            }

            if (user.getMobile() != null) {
                User userMobile = userRepository.findByMobile(user.getMobile());
                // System.out.println("userMobile = " + userMobile);
                if (null != userMobile) {
                    return result(ExceptionMsg.MobileUsed);
                }
            }

            // String encodePassword = MD5Util.encode(password);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            user.setCreateTime(theDateUtils.getCurrentTime());
            user.setLastModifyTime(theDateUtils.getCurrentTime());
            user.setAvatar("img/avater.png");
            List<UserRole> roles = new ArrayList<>();
            UserRole role1 = userRoleRepository.findByRolename("ROLE_USER");
            roles.add(role1);
            user.setRoles(roles);

            logger.debug(user.toString());
            System.out.println(user.toString());
            
            userRepository.save(user);

        } catch (Exception e) {

            return result(ExceptionMsg.FAILED);
        }
        return result();
    }
}
