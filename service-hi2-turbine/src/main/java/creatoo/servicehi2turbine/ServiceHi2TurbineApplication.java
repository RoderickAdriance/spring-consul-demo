package creatoo.servicehi2turbine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceHi2TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHi2TurbineApplication.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

}
