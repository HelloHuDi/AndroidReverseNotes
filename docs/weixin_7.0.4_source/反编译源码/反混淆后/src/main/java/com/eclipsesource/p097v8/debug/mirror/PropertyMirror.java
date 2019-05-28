package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.PropertyMirror */
public class PropertyMirror extends Mirror {
    PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        AppMethodBeat.m2504i(74897);
        String executeStringFunction = this.v8Object.executeStringFunction("name", null);
        AppMethodBeat.m2505o(74897);
        return executeStringFunction;
    }

    public Mirror getValue() {
        AppMethodBeat.m2504i(74898);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction("value", null);
        try {
            Mirror createMirror = Mirror.createMirror(executeObjectFunction);
            return createMirror;
        } finally {
            executeObjectFunction.release();
            AppMethodBeat.m2505o(74898);
        }
    }

    public boolean isProperty() {
        return true;
    }
}
