package com.mangrove.api.dao;

import com.mangrove.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
	 User findByUserName(String userName);

	 User save(User user);
}
