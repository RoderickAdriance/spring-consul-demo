package creatoo.servicehi;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@CrossOrigin(allowCredentials = "true", allowedHeaders="*", methods={RequestMethod.GET,RequestMethod.POST}, origins="*")
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(String name) {
        return "hi " + name + " ,i am from port:" + port ;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

    //向zipkin注册用
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
