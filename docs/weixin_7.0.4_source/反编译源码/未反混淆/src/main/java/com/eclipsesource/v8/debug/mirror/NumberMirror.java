package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NumberMirror extends ValueMirror {
    NumberMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNumber() {
        return true;
    }

    public String toString() {
        AppMethodBeat.i(74886);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.o(74886);
        return executeStringFunction;
    }
}
