package top.ljjapp.shoppoints.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author LJJ
 */
@Entity
@Data
public class ShopPoints {
    @Id
    private String pkId;

    private String userName;

    private Integer pointsNum;

    private Integer pointsTotal;

    private Date createTime;

    private Date updateTime;
}
