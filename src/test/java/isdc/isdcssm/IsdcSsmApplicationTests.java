package isdc.isdcssm;

import isdc.isdcssm.dao.UserDao;
import isdc.isdcssm.model.User;
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
	private UserDao userDao;

	public IsdcSsmApplicationTests(){

	}
	@Test
	public void contextLoads() {
			User user = userDao.selectByEmail("843874092@qq.com");
			System.out.println(user.getUserName());
		}
	}


