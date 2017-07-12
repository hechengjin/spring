package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by hechengjin on 17-7-12.
 */

//其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
@ComponentScan({"api.*","common.*"})  //*****注意写法不同会扫不到相关的异常处理类*****
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
