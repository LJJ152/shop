package top.ljjapp.shoporder.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.dao.ShopOrderRepository;
import top.ljjapp.shoporder.model.ShopOrder;
import top.ljjapp.shoporder.service.ShopOrderService;
import top.ljjapp.shoporder.service.pointsservice.PointsService;
import top.ljjapp.shoporder.service.storeservice.StoreService;
import top.ljjapp.utils.UUID;

import java.util.Date;

/**
 * @author LJJ
 */
@Service("shopOrderServiceCancel")
@Log
public class ShopOrderServiceCancel implements ShopOrderService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private PointsService pointsService;


    @Autowired
    private ShopOrderRepository shopOrderRepository;


    @Override
    @Transactional
    public Result addShopOrder(Integer store, Integer points, Integer exceptionType) {
        log.info("取消订单创建");
        return new Result(0, "取消订单创建");
    }
}
