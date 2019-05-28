package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.FunctionMirror */
public class FunctionMirror extends ObjectMirror {
    private static final String NAME = "name";
    private static final String SCRIPT = "script";

    FunctionMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        AppMethodBeat.m2504i(74868);
        String executeStringFunction = this.v8Object.executeStringFunction("name", null);
        AppMethodBeat.m2505o(74868);
        return executeStringFunction;
    }

    public String getScriptName() {
        AppMethodBeat.m2504i(74869);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SCRIPT, null);
        try {
            String executeStringFunction = executeObjectFunction.executeStringFunction("name", null);
            return executeStringFunction;
        } finally {
            executeObjectFunction.release();
            AppMethodBeat.m2505o(74869);
        }
    }

    public boolean isFunction() {
        return true;
    }
}
