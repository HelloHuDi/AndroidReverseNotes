package com.eclipsesource.p097v8.debug;

import com.eclipsesource.p097v8.V8Object;
import com.eclipsesource.p097v8.debug.DebugHandler.DebugEvent;

/* renamed from: com.eclipsesource.v8.debug.BreakHandler */
public interface BreakHandler {
    void onBreak(DebugEvent debugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
