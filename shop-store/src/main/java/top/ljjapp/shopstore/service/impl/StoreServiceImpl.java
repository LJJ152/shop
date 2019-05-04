package top.ljjapp.shopstore.service.impl;

import com.yiqiniu.easytrans.core.EasyTransFacade;
import com.yiqiniu.easytrans.protocol.BusinessProvider;
import com.yiqiniu.easytrans.protocol.tcc.EtTcc;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ljjapp.api.WalletPayMoneyService;
import top.ljjapp.api.WalletPayRequestCfg;
import top.ljjapp.base.Result;
import top.ljjapp.shopstore.dao.ShopStoreRepository;
import top.ljjapp.shopstore.model.ShopStore;
import top.ljjapp.shopstore.service.StoreService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LJJ
 */
@Service
@Log
public class StoreServiceImpl implements StoreService {

    private final String ID = "5u4c01b670c44f36b7ac9c7a41679c28";

    @Autowired
    private ShopStoreRepository shopStoreRepository;

    @Resource
    private EasyTransFacade transaction;

    @Override
    @Transactional
    @EtTcc(confirmMethod="doConfirmReduce",cancelMethod="doCancelReduce",idempotentType= BusinessProvider.IDENPOTENT_TYPE_FRAMEWORK,cfgClass= WalletPayRequestCfg.class)
    public WalletPayMoneyService.WalletPayResponseVO reduceStore(WalletPayMoneyService.WalletPayRequestVO num) {
        Result result = null;

        ShopStore shopStore = shopStoreRepository.getOne(ID);
        Integer reduce = shopStore.getStoreNum() - num.getUserId();
        //当剩余库存足够时，成功
        if (reduce >= 0) {
            shopStore.setStoreNum(reduce);
            ShopStore save = shopStoreRepository.save(shopStore);
            result = new Result(1, "减少库存成功");
        }
        else {
            result = new Result(0, "库存不足，失败");
        }
        WalletPayMoneyService.WalletPayResponseVO walletPayTccMethodResult = new WalletPayMoneyService.WalletPayResponseVO();
        return walletPayTccMethodResult;
    }


    @org.springframework.transaction.annotation.Transactional
    public void doConfirmReduce(WalletPayMoneyService.WalletPayRequestVO num) {
        log.info("减少库存成功");
    }

    @org.springframework.transaction.annotation.Transactional
    public void doCancelReduce(WalletPayMoneyService.WalletPayRequestVO num) {
        ShopStore shopStore = shopStoreRepository.getOne(ID);
        Integer reduce = shopStore.getStoreNum() + num.getUserId();
        shopStore.setStoreNum(reduce);
        ShopStore save = shopStoreRepository.save(shopStore);
        log.info("减少库存cancel");
    }
}
