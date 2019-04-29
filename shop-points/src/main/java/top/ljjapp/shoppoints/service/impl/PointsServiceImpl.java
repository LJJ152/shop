package top.ljjapp.shoppoints.service.impl;

import lombok.extern.java.Log;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ljjapp.base.Result;
import top.ljjapp.shoppoints.dao.ShopPonintsRepository;
import top.ljjapp.shoppoints.model.ShopPoints;
import top.ljjapp.shoppoints.service.PointsService;

import javax.transaction.Transactional;

@Service
@Log
public class PointsServiceImpl implements PointsService {

    private String ID = "1t4b6ff98075462ea909ed5ba166c912";

    @Autowired
    private ShopPonintsRepository shopPonintsRepository;

    @Override
    @Transactional
    @Hmily(confirmMethod = "confirmShopPoints", cancelMethod = "cancelShopPoints")
    public Result addPoints(Integer num) {
        Result result = null;
        ShopPoints shopPoints = shopPonintsRepository.getOne(ID);
        shopPoints.setPointsNum(shopPoints.getPointsNum() + num);
        shopPoints.setPointsTotal(shopPoints.getPointsTotal() + num);
        shopPonintsRepository.save(shopPoints);
        result = new Result(1, "积分添加成功");
        return result;
    }

    public void confirmShopPoints(Integer num) {
        log.info("执行积分confirm方法，减少积分成功");
    }

    public void cancelShopPoints(Integer num) {
        log.info("执行积分cancel方法，将增加的积分减少");
        ShopPoints shopPoints = shopPonintsRepository.getOne(ID);
        shopPoints.setPointsNum(shopPoints.getPointsNum() - num);
        shopPoints.setPointsTotal(shopPoints.getPointsTotal() - num);
        shopPonintsRepository.save(shopPoints);
    }
}
