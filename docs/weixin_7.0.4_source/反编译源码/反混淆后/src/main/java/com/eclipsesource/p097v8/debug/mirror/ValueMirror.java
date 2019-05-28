package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.ValueMirror */
public class ValueMirror extends Mirror {
    private static final String VALUE = "value";

    ValueMirror(V8Object v8Object) {
        super(v8Object);
    }

    public Object getValue() {
        AppMethodBeat.m2504i(74911);
        Object executeFunction = this.v8Object.executeFunction("value", null);
        AppMethodBeat.m2505o(74911);
        return executeFunction;
    }

    public boolean isValue() {
        return true;
    }
}
