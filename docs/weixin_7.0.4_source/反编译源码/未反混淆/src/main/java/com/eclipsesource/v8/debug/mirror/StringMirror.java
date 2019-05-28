package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StringMirror extends ValueMirror {
    StringMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isString() {
        return true;
    }

    public String toString() {
        AppMethodBeat.i(74910);
        String executeStringFunction = this.v8Object.executeStringFunction("toText", null);
        AppMethodBeat.o(74910);
        return executeStringFunction;
    }
}
