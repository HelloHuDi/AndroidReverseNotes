package com.tencent.mm.pluginsdk.g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class f extends IOException {
    public final int httpStatusCode;
    public final IOException veV;

    public f(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.veV = iOException;
    }

    public final String toString() {
        AppMethodBeat.i(79566);
        String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.veV + '}';
        AppMethodBeat.o(79566);
        return str;
    }
}
