package com.zdf.flowsvr.data.po;

import lombok.Data;

@Data
public class ScheduleConfig {
    /**
     * 任务类型
     */
    private String task_type;
    /**
     * 一次性拉取任务数量
     */
    private Integer schedule_limit;
    /**
     * -10表示均匀10秒执行
     * +10表示渐进式重试比如1,2,4,8,10
     */
    private Integer schedule_interval;
    /**
     * 执行中的最长执行时间
     */
    private Integer max_processing_time;
    /**
     * 最大重试次数
     */
    private Integer max_retry_num;
    /**
     * 重试间隔
     */
    private Integer retry_interval;
    private Long create_time;
    private Long modify_time;
}
