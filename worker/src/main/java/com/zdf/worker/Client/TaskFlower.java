package com.zdf.worker.Client;

import com.zdf.worker.data.AsyncTaskRequest;
import com.zdf.worker.data.AsyncTaskReturn;
import com.zdf.worker.data.AsyncTaskSetRequest;
import com.zdf.worker.data.ScheduleConfig;
import com.zdf.worker.enums.TaskStatus;

import java.util.List;

public interface TaskFlower {
    String createTask(AsyncTaskRequest asyncTaskRequest);
    void setTask(AsyncTaskSetRequest asyncTaskSetRequest);
    AsyncTaskReturn getTask(String taskId);
    List<AsyncTaskReturn> getTaskList(Class<?> clazz, int status, int limit);
    List<ScheduleConfig> getTaskTypeCfgList();
    List<AsyncTaskReturn> getUserTaskList(List<TaskStatus> taskStatuses);
    void createTaskCFG(ScheduleConfig scheduleConfig);


}
