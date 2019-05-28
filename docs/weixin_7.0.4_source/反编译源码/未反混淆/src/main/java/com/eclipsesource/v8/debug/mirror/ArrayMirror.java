package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isArray() {
        return true;
    }

    public int length() {
        AppMethodBeat.i(74856);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LENGTH, null);
        AppMethodBeat.o(74856);
        return executeIntegerFunction;
    }
}
