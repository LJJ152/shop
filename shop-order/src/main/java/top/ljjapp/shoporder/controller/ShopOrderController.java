package top.ljjapp.shoporder.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.service.ShopOrderService;


/**
 * 订单管理
 * @author LJJ
 */
@RestController
@Log
@RequestMapping("/shop")
public class ShopOrderController {

    @Autowired
    private ShopOrderService shopOrderService;

    /**
     * 添加订单
     * @return
     */
    @GetMapping("/add-order")
    public Result addOrder(@RequestParam(required = true, defaultValue = "10") Integer store,
                           @RequestParam(required = true, defaultValue = "10") Integer points) {
        Result result = shopOrderService.addShopOrder(store, points);
        return result;
    }

}
