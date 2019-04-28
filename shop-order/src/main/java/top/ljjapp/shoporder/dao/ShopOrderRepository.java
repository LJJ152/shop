package top.ljjapp.shoporder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.ljjapp.shoporder.model.ShopOrder;

import java.util.List;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, String> {

    /**
     * 获取所有的节点数据
     * @return
     */
    @Query(value = "select * from shop_order n ", nativeQuery = true)
    List<ShopOrder> findAllList();

}
