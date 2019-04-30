package top.ljjapp.shoporder.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ShopOrder implements Serializable {

    @Id
    private String pkId;

    private String orderName;

    private String userName;

    private Integer payState;

    private Integer orderState;

    private Date createTime;

    private Date updateTime;

}
