package top.ljjapp.shopstore.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.dao.ShopStoreRepository;
import top.ljjapp.shopstore.model.ShopStore;
import top.ljjapp.shopstore.service.StoreService;

import javax.transaction.Transactional;

/**
 * @author LJJ
 */
@Service
public class StoreServiceImpl implements StoreService {

    private final String ID = "5u4c01b670c44f36b7ac9c7a41679c28";

    @Autowired
    private ShopStoreRepository shopStoreRepository;

    @Override
//    @Transactional
//    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @LcnTransaction //分布式事务注解
    public Result reduceStore(Integer num) {
        Result result = null;
        ShopStore shopStore = shopStoreRepository.getOne(ID);
        Integer reduce = shopStore.getStoreNum() - num;
        //当剩余库存足够时，成功
        if (reduce >= 0) {
            shopStore.setStoreNum(reduce);
            ShopStore save = shopStoreRepository.save(shopStore);
            result = new Result(1, "减少库存成功");
//            if (true) {
//                throw new RuntimeException("主动抛出一个异常测试");
//            }
        }
        else {
            result = new Result(0, "库存不足，失败");
        }
        return result;
    }

}
