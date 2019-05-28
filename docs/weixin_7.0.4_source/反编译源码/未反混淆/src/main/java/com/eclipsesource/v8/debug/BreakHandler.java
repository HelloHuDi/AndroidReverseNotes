package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.DebugHandler.DebugEvent;

public interface BreakHandler {
    void onBreak(DebugEvent debugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
