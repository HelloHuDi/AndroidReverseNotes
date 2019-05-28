package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.ArrayMirror */
public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isArray() {
        return true;
    }

    public int length() {
        AppMethodBeat.m2504i(74856);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LENGTH, null);
        AppMethodBeat.m2505o(74856);
        return executeIntegerFunction;
    }
}
