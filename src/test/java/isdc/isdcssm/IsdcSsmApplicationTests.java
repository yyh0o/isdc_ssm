package isdc.isdcssm;

import isdc.isdcssm.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsdcSsmApplicationTests {

	@Autowired
	private UserDAO userDAO;

	public IsdcSsmApplicationTests(){

	}
	@Test
	public void contextLoads() {

		int a[] = {62,65,20,77,69,74,68,20,75};
		for(int i =0;i<10;i++){
			System.out.print((char)a[i]);
		}
		System.out.println();
		}
	}


