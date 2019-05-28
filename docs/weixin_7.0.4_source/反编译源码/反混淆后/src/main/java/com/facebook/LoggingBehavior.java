package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoggingBehavior {
    REQUESTS,
    INCLUDE_ACCESS_TOKENS,
    INCLUDE_RAW_RESPONSES,
    CACHE,
    APP_EVENTS,
    DEVELOPER_ERRORS,
    GRAPH_API_DEBUG_WARNING,
    GRAPH_API_DEBUG_INFO;

    static {
        AppMethodBeat.m2505o(71803);
    }
}
