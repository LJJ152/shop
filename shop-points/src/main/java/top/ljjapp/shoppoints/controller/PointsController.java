package top.ljjapp.shoppoints.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ljjapp.base.Result;
import top.ljjapp.shoppoints.service.PointsService;

@RestController
@Log
@RequestMapping("/shop")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @GetMapping("/add-points")
    public Result addPoints(@RequestParam Integer num) {
        Result result = pointsService.addPoints(num);
        return result;
    }

}
