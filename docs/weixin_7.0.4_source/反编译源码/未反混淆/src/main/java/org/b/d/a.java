package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.OutputStream;

public final class a {
    public final String BYE;
    public final String BYF;
    public final String BYG;
    public final h BYI;
    private final OutputStream BYJ;
    public final String scope;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.BYE = str;
        this.BYF = str2;
        this.BYG = str3;
        this.BYI = hVar;
        this.scope = str4;
        this.BYJ = outputStream;
    }

    public final boolean emX() {
        return this.scope != null;
    }

    public final void log(String str) {
        AppMethodBeat.i(77275);
        if (this.BYJ != null) {
            try {
                this.BYJ.write(new StringBuilder(String.valueOf(str)).append(IOUtils.LINE_SEPARATOR_UNIX).toString().getBytes("UTF8"));
                AppMethodBeat.o(77275);
                return;
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException("there were problems while writting to the debug stream", e);
                AppMethodBeat.o(77275);
                throw runtimeException;
            }
        }
        AppMethodBeat.o(77275);
    }
}
