package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertyMirror extends Mirror {
    PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        AppMethodBeat.i(74897);
        String executeStringFunction = this.v8Object.executeStringFunction("name", null);
        AppMethodBeat.o(74897);
        return executeStringFunction;
    }

    public Mirror getValue() {
        AppMethodBeat.i(74898);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction("value", null);
        try {
            Mirror createMirror = Mirror.createMirror(executeObjectFunction);
            return createMirror;
        } finally {
            executeObjectFunction.release();
            AppMethodBeat.o(74898);
        }
    }

    public boolean isProperty() {
        return true;
    }
}
