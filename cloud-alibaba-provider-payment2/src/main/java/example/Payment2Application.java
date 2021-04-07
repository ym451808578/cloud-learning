package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Castle
 * @Date 2021/4/7 9:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment2Application.class, args);
    }
}
