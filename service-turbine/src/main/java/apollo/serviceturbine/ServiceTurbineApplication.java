package apollo.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class ServiceTurbineApplication {
    /**
     * http://localhost:8779/turbine.stream
     */

    public static void main(String[] args) {
        SpringApplication.run(ServiceTurbineApplication.class, args);
    }


}
