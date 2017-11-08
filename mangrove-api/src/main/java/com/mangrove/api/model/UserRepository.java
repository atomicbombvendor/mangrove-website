package com.mangrove.api.model;

import com.mangrove.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/23 下午2:34.
 * @blog http://blog.didispace.com
 */
@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String name);

    @Query("from User u where u.userName=:name and u.userPsd=:psd")
    User findUser(@Param("name") String name, @Param("psd") String psd);

    User save(User user);

}
