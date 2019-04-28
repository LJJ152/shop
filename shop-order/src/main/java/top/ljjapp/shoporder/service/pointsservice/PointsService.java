package top.ljjapp.shoporder.service.pointsservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.service.fallback.OrderClientFallback;

@FeignClient(value = "shop-points", fallback = OrderClientFallback.class)
public interface PointsService {

    @RequestMapping(value = "/shop/add-points", method = RequestMethod.GET)
    Result addPoints(@RequestParam Integer num);

}
