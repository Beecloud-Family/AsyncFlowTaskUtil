package com.zdf.flowsvr.constant;

import com.zdf.flowsvr.dao.AsyncFlowTaskDao;
import com.zdf.flowsvr.dao.TSchedulePosDao;
import com.zdf.flowsvr.data.po.TSchedulePos;
import com.zdf.flowsvr.service.AsyncTaskService;
import com.zdf.flowsvr.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author bookiosk 2024-03-05
 */
@Component
public class AsyncFlowTaskCache {

    @Autowired
    private AsyncFlowTaskDao asyncFlowTaskDao;

    @Autowired
    private TSchedulePosDao tSchedulePosDao;

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Autowired
    private RedisUtil redisUtil;

    @PostConstruct
    public void init () {
        // 先查询任务调度表,获取所有需要调度的任务以及目前的任务所处的调度位置
        List<TSchedulePos> taskPosList = tSchedulePosDao.getTaskPosList();
        if (taskPosList == null || taskPosList.isEmpty()) {
            return;
        }
        // 循环每个任务类型最后调度的几号表,获取每个表当前数据量来加入到缓存中
        for (TSchedulePos tSchedulePos : taskPosList) {
            String tableName = asyncTaskService.getTableName(tSchedulePos.getScheduleEndPos(), tSchedulePos.getTaskType());
            int i = asyncFlowTaskDao.returnTaskCount(tableName);
            redisUtil.set(tableName, i);
        }
    }
}
