package top.ljjapp.shopstore.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.service.StoreService;

@RestController
@Log
@RequestMapping("/shop")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/reduce-store")
    public Result reduceStore(@RequestParam Integer num) {
        Result result = null;
//        Result result = storeService.reduceStore(num);
        return result;
    }

}
