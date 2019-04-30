package top.ljjapp.shopstore.controller;

import lombok.extern.java.Log;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.service.StoreService;

@Compensable(
        interfaceClass = StoreService.class,
        confirmableKey = "storeServiceConfirm",
        cancellableKey = "storeServiceCancel")
@RestController
@Log
@RequestMapping("/shop")
public class StoreController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StoreService storeServiceImpl;

    @GetMapping("/reduce-store")
    public Result reduceStore(@RequestParam Integer num) {
        Result result = storeServiceImpl.reduceStore(num);
        return result;
    }

}
