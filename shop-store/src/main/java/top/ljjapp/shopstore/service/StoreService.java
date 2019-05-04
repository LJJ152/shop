package top.ljjapp.shopstore.service;

import top.ljjapp.api.WalletPayMoneyService;
import top.ljjapp.base.Result;

public interface StoreService {

    WalletPayMoneyService.WalletPayResponseVO reduceStore(WalletPayMoneyService.WalletPayRequestVO num);
}
