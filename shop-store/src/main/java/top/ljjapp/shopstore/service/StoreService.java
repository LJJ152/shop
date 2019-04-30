package top.ljjapp.shopstore.service;

import top.ljjapp.base.Result;

public interface StoreService {

    /**
     * try操作
     * @param num
     * @return
     */
    Result reduceStore(Integer num);
}
