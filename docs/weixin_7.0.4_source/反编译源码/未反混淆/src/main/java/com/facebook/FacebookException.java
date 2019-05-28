package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    public FacebookException(String str) {
        super(str);
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
        AppMethodBeat.i(71579);
        AppMethodBeat.o(71579);
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    public String toString() {
        AppMethodBeat.i(71580);
        String message = getMessage();
        AppMethodBeat.o(71580);
        return message;
    }
}
