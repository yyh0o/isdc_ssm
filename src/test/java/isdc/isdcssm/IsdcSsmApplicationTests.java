package isdc.isdcssm;

import isdc.isdcssm.dao.SemesterDAO;
import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.model.Semester;
import isdc.isdcssm.service.JoinService;
import isdc.isdcssm.service.SemesterService;
import org.assertj.core.condition.Join;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsdcSsmApplicationTests {

    @Autowired
    private JoinService joinService;

    @Autowired
    private SemesterDAO semesterDAO;

    public IsdcSsmApplicationTests() {

    }

    @Test
    public void contextLoads() {

        Optional<ApplicationForm> applicationForm = joinService.queryForm("otKSqs0djctAeS_ULupp_y-XhkA");
        System.out.println(applicationForm.isPresent());
    }
}


