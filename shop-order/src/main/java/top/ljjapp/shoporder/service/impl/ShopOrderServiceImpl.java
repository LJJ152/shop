package top.ljjapp.shoporder.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
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
@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private PointsService pointsService;


    @Autowired
    private ShopOrderRepository shopOrderRepository;


    @Override
    @Transactional
    @LcnTransaction //分布式事务注解
    public Result addShopOrder() {
        Result result = null;
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setPkId(UUID.randomUUID());
        shopOrder.setUserName("李铁花");
        shopOrder.setOrderName("" + (int)(Math.random()*1000));
        shopOrder.setOrderState(0);
        shopOrder.setPayState(0);
        shopOrder.setCreateTime(new Date(System.currentTimeMillis()));
        shopOrder.setUpdateTime(new Date(System.currentTimeMillis()));
        ShopOrder order = shopOrderRepository.save(shopOrder);
        //减少库存
        Result storeResult = storeService.reduceStore(1);
        //增加积分
        Result pointsResult = pointsService.addPoints(100);
        if (order != null) {
            result = new Result(1, "增加订单成功，" + storeResult.getMessage() + "," +pointsResult.getMessage());
        } else {
            result = new Result(0, "添加订单失败，" + storeResult.getMessage() + "," +pointsResult.getMessage());
        }
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return result;
    }
}
