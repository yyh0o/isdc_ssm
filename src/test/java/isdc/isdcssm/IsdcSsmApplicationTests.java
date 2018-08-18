package isdc.isdcssm;

import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.Semester;
import isdc.isdcssm.service.SemesterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsdcSsmApplicationTests {

	@Autowired
	private SemesterService semesterService;

	public IsdcSsmApplicationTests(){

	}
	@Test
	public void contextLoads() {

		 Semester semester =semesterService.findSemesterByDate(new Date());
		 System.out.println();
	}
	}


