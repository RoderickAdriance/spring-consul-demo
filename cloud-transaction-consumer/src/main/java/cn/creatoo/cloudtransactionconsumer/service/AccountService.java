package cn.creatoo.cloudtransactionconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-cloud-provider")
public interface AccountService {

    @RequestMapping(method = RequestMethod.POST, value = "/increase")
     void increaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount);

    @RequestMapping(method = RequestMethod.POST, value = "/decrease")
     void decreaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount);
}
