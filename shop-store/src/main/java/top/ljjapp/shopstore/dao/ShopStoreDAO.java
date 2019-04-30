package top.ljjapp.shopstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.ljjapp.shopstore.model.ShopStore;

@Repository("shopStoreDAO")
public class ShopStoreDAO implements ShopStoreRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ShopStore getOne(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM shop_store WHERE pk_id=?", new Object[] { id }, new BeanPropertyRowMapper<ShopStore>(ShopStore.class));

    }

    @Override
    public int save(ShopStore shopStore) {

        return  jdbcTemplate.update("INSERT INTO shop_store(pk_id, store_name, store_num, store_total, create_time, update_time) values(?, ?, ?, ?, ?, ?)",
                shopStore.getPkId(), shopStore.getStoreName(), shopStore.getStoreNum(), shopStore.getStoreTotal(), shopStore.getCreateTime(), shopStore.getUpdateTime());

    }
}
