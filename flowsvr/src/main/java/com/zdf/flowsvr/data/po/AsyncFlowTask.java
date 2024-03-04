package com.zdf.flowsvr.data.po;


import lombok.Data;

@Data
public class AsyncFlowTask {
    
    private String id;
    /**
     * 创建人id
     */
    private String user_id;
    /**
     * 自定义任务id类似订单号的含义
     */
    private String task_id;
    /**
     * 存储任务的全类名
     */
    private String task_type;
    /**
     * 任务所处阶段,比如这个任务有多个工作,那么目前所干的工作就对应其阶段
     */
    private String task_stage;
    /**
     * 任务当前执行状态
     */
    private int status;
    /**
     * 已重试次数
     */
    private int crt_retry_num;
    /**
     * 最大重试次数
     */
    private int max_retry_num;
    /**
     * 调度时间:时间越小,调度优先级越高
     * 创建时, order_time = 当前时间 - priority
     * 调度之后, order_time = 当前时间 - priority 始终维持优先秒数
     * 失败重试的话, order_time = 当前时间 + 当前任务的执行时间间隔(时间间隔一般由任务配置来做控制)
     * 好处就是通过这样的方式和create_time,modify_time语义隔离开来,同时还保证所有任务都有机会执行到哪怕优先级较低
     * 因为大部分情况用户派发的任务都会默认优先机是1
     */
    private long order_time;

    /**
     * 优先级
     */
    private int priority;
    /**
     * 最大重试间隔
     */
    private int max_retry_interval;
    /**
     * 执行日志:一般用于执行报错日志查看
     */
    private String schedule_log;
    /**
     * 任务上下文，用户自定义
     */
    private String task_context;
    
    private Long create_time;
    
    private Long modify_time;

}
