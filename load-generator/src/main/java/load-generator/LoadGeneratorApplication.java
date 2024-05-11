package load-generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fdse
 */
@SpringBootApplication
/*@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@IntegrationComponentScan
@EnableSwagger2*/
@EnableScheduling
public class LoadGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadGeneratorApplication.class, args);
    }

    @RestController
    public static class LoadController {

        @Scheduled(fixedRate = 1000) // 每秒生成请求数量
        public void generateLoad() {
            System.out.println("Generating load...");
        }

        @GetMapping("/load-strategy")
        public String setLoadStrategy(@RequestParam String strategy) {
            return "Load strategy set to: " + strategy;
        }
    }
}

/*
public class AdminBasicInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBasicInfoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
*/
