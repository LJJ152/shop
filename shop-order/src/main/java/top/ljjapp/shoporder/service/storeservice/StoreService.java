package top.ljjapp.shoporder.service.storeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.service.fallback.OrderClientFallback;

@FeignClient(value = "shop-store", fallback = OrderClientFallback.class)
public interface StoreService {

    @RequestMapping(value = "/shop/reduce-store", method = RequestMethod.GET)
    Result reduceStore(@RequestParam Integer num);

}
