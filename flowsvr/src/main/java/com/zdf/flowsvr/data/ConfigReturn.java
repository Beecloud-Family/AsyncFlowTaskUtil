package com.zdf.flowsvr.data;

import com.zdf.flowsvr.data.po.ScheduleConfig;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ConfigReturn {
    List<ScheduleConfig> scheduleCfgList;
}
