package isdc.isdcssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class IsdcSsmApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(IsdcSsmApplication.class, args);
    }
}
