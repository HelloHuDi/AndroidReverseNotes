package com.tencent.p177mm.pluginsdk.p592g.p593a.p595b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.g.a.b.f */
public final class C40428f extends IOException {
    public final int httpStatusCode;
    public final IOException veV;

    public C40428f(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.veV = iOException;
    }

    public final String toString() {
        AppMethodBeat.m2504i(79566);
        String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.veV + '}';
        AppMethodBeat.m2505o(79566);
        return str;
    }
}
