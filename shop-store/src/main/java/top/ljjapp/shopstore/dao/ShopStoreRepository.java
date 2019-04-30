package top.ljjapp.shopstore.dao;

import top.ljjapp.shopstore.model.ShopStore;

/**
 * @author LJJ
 */
public interface ShopStoreRepository {

    ShopStore getOne(String id);

    int save(ShopStore shopStore);

}
