package top.ljjapp.shopstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.ljjapp.shopstore.model.ShopStore;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author LJJ
 */
public interface ShopStoreRepository extends JpaRepository<ShopStore, String> {

    /**
     * 获取所有的节点数据
     * @return
     */
    @Query(value = "select * from shop_store n ", nativeQuery = true)
    List<ShopStore> findAllList();

}
