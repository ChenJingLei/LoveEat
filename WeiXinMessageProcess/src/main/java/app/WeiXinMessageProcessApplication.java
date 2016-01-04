package app;

import app.models.WeiXinConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by cjl20 on 2016/1/4.
 */
@SpringBootApplication
@EnableConfigurationProperties({WeiXinConfig.class})
public class WeiXinMessageProcessApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiXinMessageProcessApplication.class, args);
    }
}
