package top.ljjapp.shopstore.service.impl;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.service.StoreService;

/**
 * tcc cancel逻辑
 * 1.@Service("storeServiceCancel")这里必须指定此bean名称，tcc过程依靠此名称区分执行tcc中哪个逻辑
 * 2.参与tcc的方法必须添加@Transactional注解
 * 3.建议tcc每个步骤，方法执行后添加日志，方便问题排查
 *
 */
@Service("storeServiceCancel")
@Log
public class StoreServiceCancel implements StoreService {

    @Override
    @Transactional
    public Result reduceStore(Integer num) {
        log.info("取消 减少库存的操作");
        return new Result(0, "取消 减少库存的操作");
    }
}
