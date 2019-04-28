package top.ljjapp.shoppoints.service;

import top.ljjapp.base.Result;

public interface PointsService {

    /**
     * 添加积分
     * @param num
     * @return
     */
    Result addPoints(Integer num);
}
