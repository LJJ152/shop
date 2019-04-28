package top.ljjapp.shoppoints.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ljjapp.base.Result;
import top.ljjapp.shoppoints.dao.ShopPonintsRepository;
import top.ljjapp.shoppoints.model.ShopPoints;
import top.ljjapp.shoppoints.service.PointsService;

import javax.transaction.Transactional;

@Service
public class PointsServiceImpl implements PointsService {

    private String ID = "1t4b6ff98075462ea909ed5ba166c912";

    @Autowired
    private ShopPonintsRepository shopPonintsRepository;

    @Override
//    @Transactional
//    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @LcnTransaction //分布式事务注解
    public Result addPoints(Integer num) {
        Result result = null;
        ShopPoints shopPoints = shopPonintsRepository.getOne(ID);
        shopPoints.setPointsNum(shopPoints.getPointsNum() + num);
        shopPoints.setPointsTotal(shopPoints.getPointsTotal() + num);
        shopPonintsRepository.save(shopPoints);
        result = new Result(1, "积分添加成功");
        return result;
    }

}
