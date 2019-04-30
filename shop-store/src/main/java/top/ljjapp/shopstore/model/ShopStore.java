package top.ljjapp.shopstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author LJJ
 */
@Entity
@Table(name = "shop_store")
@Data
public class ShopStore implements Serializable {
    @Id
    private String pkId;

    private String storeName;

    private Integer storeNum;

    private Integer storeTotal;

    private Date createTime;

    private Date updateTime;
}
