package com.zdf.worker.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 任务状态
@Getter
public enum TaskStatus {
    // 待执行
    PENDING(0x01),
    // 执行中
    EXECUTING(0x02),
    // 执行成功
    SUCCESS(0x04),
    // 执行失败
    FAIL(0x08);
    private final int status;

    private TaskStatus(int status) {
        this.status = status;
    }


    public List<TaskStatus> getAliveStatus() {
        List<TaskStatus> aliveList = new ArrayList<>();
        aliveList.add(PENDING);
        aliveList.add(EXECUTING);
        return aliveList;
    }

    public List<TaskStatus> getFailStatus() {
        List<TaskStatus> failList = new ArrayList<>();
        failList.add(FAIL);
        return failList;
    }

    public List<TaskStatus> getSuccessStatus() {
        List<TaskStatus> sucList = new ArrayList<>();
        sucList.add(SUCCESS);
        return sucList;
    }

    public List<TaskStatus> getAllStatus() {
        List<TaskStatus> list = new ArrayList<>();
        Collections.addAll(list, TaskStatus.values());
        return list;
    }
}
