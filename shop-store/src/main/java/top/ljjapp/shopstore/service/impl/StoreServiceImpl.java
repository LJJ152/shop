package top.ljjapp.shopstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.dao.ShopStoreRepository;
import top.ljjapp.shopstore.model.ShopStore;
import top.ljjapp.shopstore.service.StoreService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author LJJ
 */
@Service
public class StoreServiceImpl implements StoreService {

    private final String ID = "5u4c01b670c44f36b7ac9c7a41679c28";

    @Autowired
    private ShopStoreRepository shopStoreRepository;

    @Override
    @Transactional
    public Result reduceStore(Integer num) {
        Result result = null;

        ShopStore shopStore = shopStoreRepository.getOne(ID);
        Integer reduce = shopStore.getStoreNum() - num;
        //当剩余库存足够时，成功
        if (reduce >= 0) {
            shopStore.setStoreNum(reduce);
            ShopStore save = shopStoreRepository.save(shopStore);
            result = new Result(1, "减少库存成功");
        }
        else {
            result = new Result(0, "库存不足，失败");
        }
        return result;
    }

}
