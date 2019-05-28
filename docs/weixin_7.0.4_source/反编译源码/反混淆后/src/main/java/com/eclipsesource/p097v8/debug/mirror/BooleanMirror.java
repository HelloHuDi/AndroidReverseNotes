package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.BooleanMirror */
public class BooleanMirror extends ValueMirror {
    BooleanMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isBoolean() {
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(74857);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.m2505o(74857);
        return executeStringFunction;
    }
}
