package cn.creatoo.cloudtransactionprovider;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import(SpringCloudSecondaryConfiguration.class)
@SpringBootApplication(exclude = { MongoAutoConfiguration.class })
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudTransactionProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTransactionProviderApplication.class, args);
    }
}
