package top.ljjapp.shopstore.model;

import lombok.Data;

import java.util.Date;

/**
 * @author LJJ
 */
@Data
public class ShopStore {
    private String pkId;

    private String storeName;

    private Integer storeNum;

    private Integer storeTotal;

    private Date createTime;

    private Date updateTime;
}
