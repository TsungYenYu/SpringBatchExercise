package completeWithExplanation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//找不到或無法載入主要類別 noCompare.Application ， 用上面的套件的來跑
@SpringBootApplication
public class ApplicationEx {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationEx.class, args);
    }
}
