package com.mangrove.api;


import com.mangrove.api.Application;
import com.mangrove.api.model.User;
import com.mangrove.api.model.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {

		// 创建10条记录
		userRepository.save(new User("AAA","AAA1", null));
		userRepository.save(new User("BBB", "AAA1", null));
		userRepository.save(new User("CCC", "AAA1", null));
		userRepository.save(new User("DDD", "AAA1", null));
		userRepository.save(new User("EEE", "AAA1", null));
		userRepository.save(new User("FFF", "AAA5", null));
		userRepository.save(new User("GGG", "AAA1", null));
		userRepository.save(new User("HHH", "AAA1", null));
		userRepository.save(new User("III", "AAA1", null));
		userRepository.save(new User("JJJ", "AAA1", null));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals("AAA5", userRepository.findByUserName("FFF").getUserPsd());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByUserName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

	}


}
