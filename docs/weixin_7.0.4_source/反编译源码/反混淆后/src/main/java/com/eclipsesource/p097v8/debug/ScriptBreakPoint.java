package com.eclipsesource.p097v8.debug;

import com.eclipsesource.p097v8.Releasable;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.eclipsesource.p097v8.V8ResultUndefined;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.ScriptBreakPoint */
public class ScriptBreakPoint implements Releasable {
    private static final String CONDITION = "condition";
    private static final String LINE = "line";
    private static final String NUMBER = "number";
    private static final String SET_CONDITION = "setCondition";
    private V8Object v8Object;

    ScriptBreakPoint(V8Object v8Object) {
        AppMethodBeat.m2504i(74912);
        this.v8Object = v8Object.twin();
        AppMethodBeat.m2505o(74912);
    }

    public int getBreakPointNumber() {
        AppMethodBeat.m2504i(74913);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(NUMBER, null);
        AppMethodBeat.m2505o(74913);
        return executeIntegerFunction;
    }

    public int getLine() {
        AppMethodBeat.m2504i(74914);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LINE, null);
        AppMethodBeat.m2505o(74914);
        return executeIntegerFunction;
    }

    public void setCondition(String str) {
        AppMethodBeat.m2504i(74915);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        try {
            this.v8Object.executeVoidFunction(SET_CONDITION, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.m2505o(74915);
        }
    }

    public String getCondition() {
        AppMethodBeat.m2504i(74916);
        String executeStringFunction;
        try {
            executeStringFunction = this.v8Object.executeStringFunction(CONDITION, null);
            AppMethodBeat.m2505o(74916);
            return executeStringFunction;
        } catch (V8ResultUndefined e) {
            executeStringFunction = "undefined";
            AppMethodBeat.m2505o(74916);
            return executeStringFunction;
        }
    }

    public void release() {
        AppMethodBeat.m2504i(74917);
        if (!(this.v8Object == null || this.v8Object.isReleased())) {
            this.v8Object.release();
            this.v8Object = null;
        }
        AppMethodBeat.m2505o(74917);
    }
}
