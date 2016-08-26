import com.helljava.helpring.config.JavaConfig;
import com.helljava.helpring.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yongjunjung on 2016. 8. 23..
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);


    }

}
