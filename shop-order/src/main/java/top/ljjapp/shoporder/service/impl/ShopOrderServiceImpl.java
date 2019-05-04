package top.ljjapp.shoporder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ljjapp.api.WalletPayMoneyService;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.dao.ShopOrderRepository;
import top.ljjapp.shoporder.model.ShopOrder;
import top.ljjapp.shoporder.service.ShopOrderService;
import top.ljjapp.shoporder.service.pointsservice.PointsService;
import top.ljjapp.shoporder.service.storeservice.StoreService;
import top.ljjapp.utils.UUID;

import javax.annotation.Resource;
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

    @Resource
    private WalletPayMoneyService payService;


    @Override
    @Transactional
    public Result addShopOrder(Integer store, Integer points, Integer exceptionType) {
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
//        Result storeResult = storeService.reduceStore(store);

        WalletPayMoneyService.WalletPayRequestVO request = new WalletPayMoneyService.WalletPayRequestVO();
        request.setUserId(store);
        request.setPayAmount(new Long(points));

        WalletPayMoneyService.WalletPayResponseVO pay = payService.pay(request);

        WalletPayMoneyService.WalletPayResponseVO storeResult = payService.pay(request);
        //增加积分
        Result pointsResult = pointsService.addPoints(points);
        if (order != null) {
            result = new Result(1, "增加订单成功，" + "," +pointsResult.getMessage());
        } else {
            result = new Result(0, "添加订单失败，" + "," +pointsResult.getMessage());
        }
        if (exceptionType == 0) {
            throw new RuntimeException("主动抛出一个异常");
        }

        return result;
    }
}
