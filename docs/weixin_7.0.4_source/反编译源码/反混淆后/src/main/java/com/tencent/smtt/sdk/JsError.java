package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError {
    /* renamed from: a */
    private final IX5JsError f1366a;

    protected JsError(IX5JsError iX5JsError) {
        this.f1366a = iX5JsError;
    }

    public String getMessage() {
        AppMethodBeat.m2504i(63927);
        String message = this.f1366a.getMessage();
        AppMethodBeat.m2505o(63927);
        return message;
    }

    public String getStack() {
        AppMethodBeat.m2504i(63928);
        String stack = this.f1366a.getStack();
        AppMethodBeat.m2505o(63928);
        return stack;
    }
}
