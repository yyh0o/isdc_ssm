package isdc.isdcssm;

import isdc.isdcssm.dao.UserMapper;
import isdc.isdcssm.model.User;
import isdc.isdcssm.model.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsdcSsmApplicationTests {

	@Autowired
	private  UserMapper userMapper;

	public IsdcSsmApplicationTests(){

	}
	@Test
	public void contextLoads() {
		User user1 = new User();
		user1.setEmail("111111111");
		User user2 = new User();
		user2.setEmail("222222222");
		List<User> list = new ArrayList<User>();
		System.out.println(list.get(0)==null);

		}
	}


