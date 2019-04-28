package top.ljjapp.shoporder.service.fallback;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import org.springframework.stereotype.Component;
import top.ljjapp.base.Result;
import top.ljjapp.shoporder.service.pointsservice.PointsService;
import top.ljjapp.shoporder.service.storeservice.StoreService;

@Component
public class OrderClientFallback implements StoreService, PointsService {

    @Override
    public Result reduceStore(Integer num) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return new Result(0, "减少库存失败");
    }

    @Override
    public Result addPoints(Integer num) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return new Result(0, "添加积分失败");
    }
}
