package com.tencent.matrix.mrs.core;

import java.util.Map;

public interface IReportCallback {
    void onStatusChanged(Map<String, Boolean> map);
}
