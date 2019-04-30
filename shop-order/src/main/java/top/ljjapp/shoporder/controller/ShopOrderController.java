package top.ljjapp.shoporder.controller;

import lombok.extern.java.Log;
import org.bytesoft.compensable.Compensable;
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
@Compensable(
        interfaceClass = ShopOrderService.class,
        cancellableKey = "shopOrderServiceCancel"
)
public class ShopOrderController {

    @Autowired
    private ShopOrderService shopOrderServiceImpl;

    /**
     * 添加订单
     * @return
     */
    @GetMapping("/add-order")
    public Result addOrder(@RequestParam(required = true, defaultValue = "10") Integer store,
                           @RequestParam(required = true, defaultValue = "10") Integer points,
                           @RequestParam(required = false)Integer exceptionType) {
        Result result = shopOrderServiceImpl.addShopOrder(store, points, exceptionType);
        return result;
    }

}
