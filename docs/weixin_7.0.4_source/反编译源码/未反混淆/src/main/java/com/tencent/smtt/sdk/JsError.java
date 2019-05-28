package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError {
    private final IX5JsError a;

    protected JsError(IX5JsError iX5JsError) {
        this.a = iX5JsError;
    }

    public String getMessage() {
        AppMethodBeat.i(63927);
        String message = this.a.getMessage();
        AppMethodBeat.o(63927);
        return message;
    }

    public String getStack() {
        AppMethodBeat.i(63928);
        String stack = this.a.getStack();
        AppMethodBeat.o(63928);
        return stack;
    }
}
