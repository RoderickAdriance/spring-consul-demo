package creatoo.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {
    @RequestMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
