package isdc.isdcssm;

import isdc.isdcssm.dao.BlogDAO;
import isdc.isdcssm.dao.BlogDataDAO;
import isdc.isdcssm.dao.SemesterDAO;
import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.model.BlogData;
import isdc.isdcssm.model.Semester;
import isdc.isdcssm.service.Impl.BlogServiceImpl;
import isdc.isdcssm.service.JoinService;
import isdc.isdcssm.service.SemesterService;
import org.assertj.core.condition.Join;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsdcSsmApplicationTests
{

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private BlogDataDAO blogDataDAO;

    public IsdcSsmApplicationTests()
    {

    }

    @Test
    public void contextLoads()
    {
        blogService.updateBlogData();
    }

    @Test
    public void BlogDataDAOTest()
    {
        blogService.updateBlogData();
    }
}


