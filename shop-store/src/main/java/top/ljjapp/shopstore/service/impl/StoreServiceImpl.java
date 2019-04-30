package top.ljjapp.shopstore.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.dao.ShopStoreDAO;
import top.ljjapp.shopstore.model.ShopStore;
import top.ljjapp.shopstore.service.StoreService;

/**
 * tcc try逻辑
 * 1.@Service("storeServiceImpl")这里必须指定此bean名称，tcc过程依靠此名称区分执行tcc中哪个逻辑
 * 2.参与tcc的方法必须添加@Transactional注解
 * 3.建议tcc每个步骤，方法执行后添加日志，方便问题排查
 * @author LJJ
 */
@Service("storeServiceImpl")
@Log
public class StoreServiceImpl implements StoreService {

    private final String ID = "5u4c01b670c44f36b7ac9c7a41679c28";

    @Autowired
    private ShopStoreDAO shopStoreDAO;

    @Override
    @Transactional
    public Result reduceStore(Integer num) {
        Result result = null;

        ShopStore shopStore = shopStoreDAO.getOne(ID);
        Integer reduce = shopStore.getStoreNum() - num;
        //当剩余库存足够时，成功
        if (reduce >= 0) {
            shopStore.setStoreNum(reduce);
            shopStoreDAO.save(shopStore);
            result = new Result(1, "减少库存成功");
        }
        else {
            result = new Result(0, "库存不足，失败");
        }
        return result;
    }

}
