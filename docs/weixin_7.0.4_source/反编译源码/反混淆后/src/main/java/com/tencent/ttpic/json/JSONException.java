package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JSONException extends RuntimeException {
    private static final long serialVersionUID = 0;
    private Throwable cause;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(Throwable th) {
        super(th.getMessage());
        AppMethodBeat.m2504i(50106);
        this.cause = th;
        AppMethodBeat.m2505o(50106);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
