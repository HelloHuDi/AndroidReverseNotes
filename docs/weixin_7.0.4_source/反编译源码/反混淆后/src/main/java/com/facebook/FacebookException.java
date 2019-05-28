package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    public FacebookException(String str) {
        super(str);
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
        AppMethodBeat.m2504i(71579);
        AppMethodBeat.m2505o(71579);
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    public String toString() {
        AppMethodBeat.m2504i(71580);
        String message = getMessage();
        AppMethodBeat.m2505o(71580);
        return message;
    }
}
