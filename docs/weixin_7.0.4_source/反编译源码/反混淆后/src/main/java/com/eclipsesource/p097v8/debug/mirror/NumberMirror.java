package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.NumberMirror */
public class NumberMirror extends ValueMirror {
    NumberMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNumber() {
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(74886);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.m2505o(74886);
        return executeStringFunction;
    }
}
